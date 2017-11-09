package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.ModelType;
import io.github.d2edev.ccc.api.SetModelValue;

@ModelType(ModelType.COMPLEX)
public class ConnectedUsers {
	//reply example
	//var stream_num="0";
	
	private int connectedUsersQty;
	
	@GetModelValue(key = "stream_num")
	public int getConnectedUsersQty() {
		return connectedUsersQty;
	}
	
	@SetModelValue(key = "stream_num")
	public void setConnectedUsersQty(int connectedUsersQty) {
		this.connectedUsersQty = connectedUsersQty;
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
