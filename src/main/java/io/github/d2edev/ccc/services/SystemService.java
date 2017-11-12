package io.github.d2edev.ccc.services;

import java.io.IOException;

import io.github.d2edev.ccc.api.AbstractService;
import io.github.d2edev.ccc.api.MarshallException;
import io.github.d2edev.ccc.api.UnmarshallException;
import io.github.d2edev.ccc.base.CameraHttpClient;
import io.github.d2edev.ccc.models.ActiveStreamsQ;
import io.github.d2edev.ccc.models.DeviceType;
import io.github.d2edev.ccc.models.ServerInfo;
import io.github.d2edev.ccc.models.ServerTime;
import io.github.d2edev.ccc.models.SimpleResponse;
import io.github.d2edev.ccc.requests.system.GetActiveStreamsQ;
import io.github.d2edev.ccc.requests.system.GetDeviceType;
import io.github.d2edev.ccc.requests.system.GetServerInfo;
import io.github.d2edev.ccc.requests.system.GetServerTime;
import io.github.d2edev.ccc.requests.system.SetServerTime;

public class SystemService extends AbstractService{

	public SystemService(CameraHttpClient client) {
		super(client);
	}
	
	
	public int getActiveStreamQuantity() throws MarshallException, IOException, UnmarshallException {
		GetActiveStreamsQ request=new GetActiveStreamsQ();
		ActiveStreamsQ streams=(ActiveStreamsQ)client.processRequest(request,request.getExpectedResponseType());
		return streams.getQuantity();
	}

	public String getDeviceType() throws MarshallException, IOException, UnmarshallException {
		GetDeviceType request=new GetDeviceType();
		DeviceType result=(DeviceType)client.processRequest(request,request.getExpectedResponseType());
		return result.getEncodedDeviceType();
	}
	
	public ServerInfo getServerInfo() throws MarshallException, IOException, UnmarshallException {
		GetServerInfo request=new GetServerInfo();
		return (ServerInfo)client.processRequest(request, request.getExpectedResponseType());
	}
	
	public ServerTime getServerTime() throws MarshallException, IOException, UnmarshallException {
		GetServerTime request=new GetServerTime();
		return (ServerTime)client.processRequest(request, request.getExpectedResponseType());
	}
	
	public boolean setServerTime(ServerTime time) throws MarshallException, IOException, UnmarshallException {
		SetServerTime request=new SetServerTime();
		request.setServerTime(time);
		return ((SimpleResponse)client.processRequest(request, request.getExpectedResponseType())).isSuccessfull();
		
	}
}
