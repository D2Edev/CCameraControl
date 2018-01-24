package io.github.d2edev.ccc.base;

import java.io.IOException;
import java.util.Base64;

import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.Marshaller;
import io.github.d2edev.ccc.api.UnmarshallException;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CameraHttpClient {

	private OkHttpClient client;
	private boolean useAuth;
	private String authData;
	private String basicUrl;
	private Marshaller<AbstractCamRequest, Request.Builder> marshaller = new RequestMarshaller();
	private Unmarshaller unmarshaller = new Unmarshaller();
	private String host;
	private String password;
	private String login;
	private int port;

	public CameraHttpClient(String host, int port) {
		this(host, port, null, null);
	}

	public CameraHttpClient(String host, int port, String login, String password) {
		this.host = host;
		this.port = port;
		this.login = login;
		this.password = password;
		client = new OkHttpClient();
		refreshURL();
		refreshToken();
	}

	// blocking
	public <T> T processRequest(AbstractCamRequest camRq, Class<T> responseClass)
			throws MarshallException, IOException, UnmarshallException {
		camRq.setBasicURL(basicUrl);
		Builder rqb = marshaller.marshall(camRq);
		if (useAuth) {
			rqb.addHeader("Authorization", authData);
		}
		Request r = rqb.build();
//		System.out.println(r);
		Response response = client.newCall(r).execute();
		// System.out.println(response.code());
		return unmarshaller.unmarshall(response, responseClass);
	}

	// blocking, helper method
	public Response processRequest(AbstractCamRequest camRq)
			throws MarshallException, IOException, UnmarshallException {
		camRq.setBasicURL(basicUrl);
		Builder rqb = marshaller.marshall(camRq);
		// Builder rqb = new
		// Request.Builder().url(command).post(RequestBody.create(null,
		// EMPTY_BODY));
		if (useAuth) {
			rqb.addHeader("Authorization", authData);
		}

		Request r = rqb.build();
		return client.newCall(r).execute();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
		refreshURL();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		refreshToken();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
		refreshToken();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
		refreshURL();
	}

	private void refreshURL() {
		StringBuilder basicUrlBuilder = new StringBuilder("http://").append(host);
		if (port != 80) {
			basicUrlBuilder.append(":").append(port);
		}
		basicUrl = basicUrlBuilder.toString();
	}

	private void refreshToken() {
		if (login != null || !login.isEmpty() || password != null || !password.isEmpty()) {
			useAuth = true;
			String auth = new StringBuilder(login).append(":").append(password).toString();
			byte[] encoded = Base64.getEncoder().encode(auth.getBytes());
			authData = new StringBuilder("Basic ").append(new String(encoded)).toString();
		}
	}

}
