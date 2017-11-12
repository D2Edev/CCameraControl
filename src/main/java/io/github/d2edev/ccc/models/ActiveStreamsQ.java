package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.ModelType;
import io.github.d2edev.ccc.api.SetModelValue;

@ModelType(ModelType.COMPLEX)
public class ActiveStreamsQ {
	//reply example
	//var stream_num="0";
	
	private int quantity;
		
	@GetModelValue(key = "stream_num")
	public int getQuantity() {
		return quantity;
	}

	@SetModelValue(key = "stream_num")
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActiveStreams [quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}

	
	

}
