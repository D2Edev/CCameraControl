package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.ModelType;

@ModelType(ModelType.SIMPLE)
public class SimpleResponse {
	//possible replies:
	//[Succeed]set ok.
	//[Error]Param error.
	
	private boolean successfull;
	private String message;

	public boolean isSuccessfull() {
		return successfull;
	}

	public void setSuccessfull(boolean successfull) {
		this.successfull = successfull;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SimpleResponse [success=");
		builder.append(successfull);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
	
	

}
