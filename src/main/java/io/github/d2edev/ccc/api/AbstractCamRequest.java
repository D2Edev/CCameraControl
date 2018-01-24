package io.github.d2edev.ccc.api;

public class AbstractCamRequest implements CamRequestNew{
	
	public static final String PARAM_ENDPOINT = "/cgi-bin/hi3510/param.cgi";
//	public static final String BACKUP_ENDPOINT = "/tmpfs/config_backup.bin";
	public static final String BACKUP_ENDPOINT = "/cgi-bin/hi3510/backup.cgi";
	public static final String RESTORE_ENDPOINT = "/cgi-bin/hi3510/restore.cgi";
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";

	protected String command;
	protected String method=METHOD_POST;
	protected String endpoint=PARAM_ENDPOINT;
	protected boolean binary=false;
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

	public String getMethod() {
		return method;
	}

	public boolean isBinary() {
		return binary;
	}
}
