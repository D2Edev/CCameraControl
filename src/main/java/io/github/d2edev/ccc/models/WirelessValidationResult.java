package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.helper.Key;

@Model
public class WirelessValidationResult {
	// ***Generated automatically ***

	//reply example: var chkres="0";
	//comment for variable linked to key [chkres] goes here
	@Key("chkres")
	private boolean validated;
	
	//comment for setter related to [chkres] goes here
	@SetModelValue(key="chkres")
	public void setValidated(boolean validated){
	this.validated=validated;
	}

	//comment for getter related to [chkres] goes here
	@GetModelValue(key="chkres")
	public boolean isValidated(){
	return validated;
	}

}
