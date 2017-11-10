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
	
	private static final int DEFAULT_HTTP_PORT = 80;
	private static final String DEFAULT_ENDPOINT = "/cgi-bin/hi3510/param.cgi";
	private String host;
	private int port=DEFAULT_HTTP_PORT;;
	private String login;
	private String password;

	private SystemService systemService;
	private VideoService videoService;
	private NetworkService networkService;
	private CameraHttpClient client;
	private String endpoint;
	
	

	public IPCamera(String host) throws Exception {
		this(host, 0,DEFAULT_ENDPOINT,null, null);
	}

	public IPCamera(String host, int port) throws Exception {
		this(host, port, DEFAULT_ENDPOINT,null, null);
	}



	public IPCamera(String host, int port,String endpoint,String login, String password) throws Exception {
		if(host==null||host.isEmpty())throw new IllegalArgumentException("Hostname not valid");
		if(port>1024&&port<65535){
			this.port = port;			
		}
		this.host = host;
		this.login = login;
		this.password = password;
		init();
	}
	
	private void init() throws Exception {
		checkIfOnline();
		client=new CameraHttpClient(host,port,login,password,endpoint);
		videoService=new VideoService(client);
		systemService=new SystemService(client);
		networkService=new NetworkService(client);
		
	}

	private void checkIfOnline() throws Exception {
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

	public String getHost() {
		return host;
	}

	public String getLogin() {
		return login;
	}


	public String getPassword() {
		return password;
	}

	public String getEndpoint() {
		return endpoint;
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
