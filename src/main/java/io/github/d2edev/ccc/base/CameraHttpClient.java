package io.github.d2edev.ccc.base;

import java.io.IOException;
import java.util.Base64;

import javax.management.OperationsException;

import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class CameraHttpClient {

	private OkHttpClient client;
	private boolean useAuth;
	private String authData;
	private String basicUrl;
	private Marshaller marshaller=new Marshaller();
	private Unmarshaller unmarshaller=new Unmarshaller();
	
	public CameraHttpClient(String host, int port, String endpoint){
		this(host, port, null, null, endpoint);
	} 
	

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
			basicUrlBuilder.append(endpoint).append("?");
		}
		basicUrl = basicUrlBuilder.toString();
	}
	
	//blocking
	public <T>T processRequest(Object request,Class<T> responseClass) throws MarshallException, IOException, UnmarshallException{
		String query=marshaller.marshall(request);
		String command=new StringBuilder(basicUrl).append(query).toString();
		
		Builder rqb = new Request.Builder().url(command);
		if(useAuth){
			rqb.addHeader("Authorization", authData);
		}
		System.out.println("request: "+command);
		Response response=client.newCall(rqb.build()).execute();
		if(response.isSuccessful()){
			return unmarshaller.unmarshall(response.body().charStream(), responseClass);
		}else{
			return null;
		}
		
	}
	
	//blocking, helper method
	public String processRequest(Object request) throws MarshallException, IOException, UnmarshallException{
		String query=marshaller.marshall(request);
		String command=new StringBuilder(basicUrl).append(query).toString();
		
		Builder rqb = new Request.Builder().url(command);
		if(useAuth){
			rqb.addHeader("Authorization", authData);
		}
		Response response=client.newCall(rqb.build()).execute();
		if(response.isSuccessful()){
			return response.body().string();
		}else{
			return null;
		}
		
	}

}