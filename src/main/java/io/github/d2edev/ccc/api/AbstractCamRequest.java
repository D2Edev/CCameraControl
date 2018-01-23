package io.github.d2edev.ccc.api;

public class AbstractCamRequest implements CamRequestNew{
	
	public static final String PARAM_ENDPOINT = "/cgi-bin/hi3510/param.cgi?";

	protected String command;
	protected String endpoint=PARAM_ENDPOINT;
	private String urlPrefix;

	@Override
	public String getCamCommand() {
		return command;
	}

	@Override
	public String getEndpoint() {
		return endpoint;
	}

	@Override
	public void setBasicURL(String url) {
		this.urlPrefix=url;
		
	}

	@Override
	public String getBasicURL() {
		return urlPrefix;
	}

}
