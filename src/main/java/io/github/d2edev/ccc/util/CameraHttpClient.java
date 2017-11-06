package io.github.d2edev.ccc.util;

import java.util.Base64;

import okhttp3.OkHttpClient;

public class CameraHttpClient {

	private OkHttpClient client;
	private boolean useAuth;
	private String authData;
	String basicUrl;

	public CameraHttpClient(String host, int port, String login, String password, String endpoint) {
		client = new OkHttpClient();
		if(login!=null||!login.isEmpty()||password!=null||!password.isEmpty()){
			useAuth=true;
			String auth = new StringBuilder(login).append(":").append(password).toString();
			byte[] encoded = Base64.getEncoder().encode(auth.getBytes());
			authData = new StringBuilder("Basic ").append(new String(encoded)).toString();
		}
		StringBuilder basicUrlBuilder=new StringBuilder("http://").append(host);
		if(port!=80){
			basicUrlBuilder.append(":").append(port);
		}
		if(endpoint!=null&&!endpoint.isEmpty()&&endpoint.startsWith("/")){
			basicUrlBuilder.append(endpoint).append("/");
		}
		basicUrl = basicUrlBuilder.toString();
	}
	
	public <T>T processRequest(Object request,Class<T> responseClass){
		return null;
		
	}

}
