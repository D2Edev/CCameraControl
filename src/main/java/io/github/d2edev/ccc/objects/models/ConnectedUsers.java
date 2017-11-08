package io.github.d2edev.ccc.objects.models;

import io.github.d2edev.ccc.objects.base.QueryParameter;

public class ConnectedUsers {
	//reply example
	//var stream_num="0";
	
	@QueryParameter(get="stream_num")
	private int connectedUsersQty;
	
	public int getConnectedUsersQty() {
		return connectedUsersQty;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConnectedUsers [");
		builder.append(connectedUsersQty);
		builder.append("]");
		return builder.toString();
	}
	
	

}
