package io.github.d2edev.ccc.requests.system;

import java.io.File;

import io.github.d2edev.ccc.api.AbstractCamRequest;
import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.SetModelValue;

public class MakeRestore extends AbstractCamRequest{
	
	private File backupFile;

	{
		endpoint=RESTORE_ENDPOINT;
		binary=true;
	}

	@GetModelValue(key="setting-file")
	public File getBackupFilePath() {
		return backupFile;
	}

	@SetModelValue(key="setting-file")
	public void setBackupFilePath(File backupFile) {
		this.backupFile = backupFile;
	}
	
	

}
