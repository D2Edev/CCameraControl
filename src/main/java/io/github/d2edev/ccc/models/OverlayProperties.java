package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.Model;
import io.github.d2edev.ccc.api.QueryParameterSplitter;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.IntegerState;
import io.github.d2edev.ccc.helper.Key;

@Model(Model.COMPLEX)
@QueryParameterSplitter("_")
public class OverlayProperties {

	public static final int MAX_NAME_LENGTH = 20;

	// ***Generated automatically ***

	// reply example: var place_0="0";
	// unknown parameter
	@Key("place")
	private int place;

	// reply example: var name_0=af;
	// reply example: var name_1="My Caption";
	// max len=20;
	@Key("name")
	private String name;

	// reply example: var show_0="1";
	// comment for variable linked to key [show_0] goes here
	@Key("show")
	private IntegerState enabled;

	// reply example: var x_0="976";
	// x position
	@Key("x")
	private int x;

	// reply example: var format_0="0";
	// unknown parameter
	@Key("format")
	private int format;

	// reply example: var y_0="0";
	// y position
	@Key("y")
	private int y;

	// comment for setter related to [place] goes here
	@SetModelValue(key = "place")
	public void setPlace(int place) {
		this.place = place;
	}

	// comment for getter related to [place] goes here
	@GetModelValue(key = "place")
	public int getPlace() {
		return place;
	}

	// comment for setter related to [name] goes here
	@SetModelValue(key = "name")
	public void setName(String name) {
		if(name==null)return;
		if(name.length()>MAX_NAME_LENGTH){
			this.name=name.substring(0, MAX_NAME_LENGTH-1);
		}else{
			this.name = name;			
		}
	}

	/**
	 * Caption content
	 * @return caption content
	 */
	@GetModelValue(key = "name")
	public String getName() {		
		return name;
	}

	// comment for setter related to [show] goes here
	@SetModelValue(key = "show")
	public void setEnabled(IntegerState state) {
		this.enabled = state;
	}

	// comment for getter related to [show] goes here
	@GetModelValue(key = "show")
	public IntegerState isEnabled() {
		return enabled;
	}

	// comment for setter related to [x] goes here
	@SetModelValue(key = "x")
	public void setX(int x) {
		this.x = x;
	}

	// comment for getter related to [x] goes here
	@GetModelValue(key = "x")
	public int getX() {
		return x;
	}

	// comment for setter related to [format] goes here
	@SetModelValue(key = "format")
	public void setFormat(int format) {
		this.format = format;
	}

	// comment for setter related to [y] goes here
	@SetModelValue(key = "y")
	public void setY(int y) {
		this.y = y;
	}

	// comment for getter related to [y] goes here
	@GetModelValue(key = "y")
	public int getY() {
		return y;
	}

	// comment for getter related to [format] goes here
	@GetModelValue(key = "format")
	public int getFormat() {
		return format;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OverlayProperties [place=");
		builder.append(place);
		builder.append(", name=");
		builder.append(name);
		builder.append(", x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", show=");
		builder.append(enabled);
		builder.append(", format=");
		builder.append(format);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OverlayProperties other = (OverlayProperties) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (enabled != other.enabled)
			return false;
		return true;
	}

	
}
