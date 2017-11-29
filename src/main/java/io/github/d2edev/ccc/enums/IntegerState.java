package io.github.d2edev.ccc.enums;



import io.github.d2edev.ccc.api.BooleanProvider;
import io.github.d2edev.ccc.api.ValueProvider;

public enum IntegerState implements ValueProvider, BooleanProvider{
	
	
	DISABLED(0), ENABLED(1);

	private IntegerState(int id) {
		this.id = id;
	}

	private int id;

	public Object value() {
		return id;
	}
	
	@Override
	public String stringValue() {
		return ""+id;
	}

	public boolean asBool() {
		if(id==1){
			return true;
		}else{
			return false;
		}
	}

}
