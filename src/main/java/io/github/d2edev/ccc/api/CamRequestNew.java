package io.github.d2edev.ccc.api;

public interface CamRequestNew {
	
	String getCamCommand();
	String getEndpoint();
	void setBasicURL(String url);
	String getBasicURL();

}
