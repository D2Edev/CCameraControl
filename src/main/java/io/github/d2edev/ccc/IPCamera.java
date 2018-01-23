package io.github.d2edev.ccc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.services.NetworkService;
import io.github.d2edev.ccc.services.SystemService;
import io.github.d2edev.ccc.services.VideoService;

public class IPCamera {
	
	public static final int DEFAULT_HTTP_PORT = 80;
	

	private SystemService systemService;
	private VideoService videoService;
	private NetworkService networkService;
	private CameraHttpClient client;
	
	

	public IPCamera(String host) {
		this(host, DEFAULT_HTTP_PORT,null, null);
	}

	public IPCamera(String host, int port){
		this(host, port, null, null);
	}



	public IPCamera(String host, int port,String login, String password) {
		if(host==null||host.isEmpty())throw new IllegalArgumentException("Hostname not valid");
		if(port<1||port>65535){
			port=DEFAULT_HTTP_PORT;			
		}
//		checkIfOnline();
		client=new CameraHttpClient(host,port,login,password);
		videoService=new VideoService(client);
		systemService=new SystemService(client);
		networkService=new NetworkService(client);
	}


	private void checkIfOnline(String host, int port) throws Exception {
		Socket socket = null;
		try {
			SocketAddress sockaddr = new InetSocketAddress(host, port);
			socket = new Socket();
			socket.connect(sockaddr, 5000);
		} catch (Exception e) {
			throw e;
		} finally {
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException nop) {
				}
			}
		}
		
	}
	
	public int getPort() {
		return client.getPort();
	}

	public void setPort(int port) {
		client.setPort(port);
	}

	public String getHost() {
		return client.getHost();
	}

	void setHost(String host){
		client.setHost(host);
	}
	
	public String getLogin() {
		return client.getLogin();
	}

	public void setLogin(String login) {
		client.setLogin(login);
	}

	public String getPassword() {
		return client.getPassword();
	}

	public void setPassword(String password) {
		client.setPassword(password);
	}

	public SystemService getSystemService() {
		return systemService;
	}

	public VideoService getVideoService() {
		return videoService;
	}

	public NetworkService getNetworkService() {
		return networkService;
	}

	
	
}
