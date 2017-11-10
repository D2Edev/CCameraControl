package io.github.d2edev.ccc.models;

import io.github.d2edev.ccc.api.GetModelValue;
import io.github.d2edev.ccc.api.ModelType;
import io.github.d2edev.ccc.api.QueryParameterSplitter;
import io.github.d2edev.ccc.api.SetModelValue;
import io.github.d2edev.ccc.enums.IntegerState;
import io.github.d2edev.ccc.helper.Key;

@ModelType(ModelType.COMPLEX)
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
	private IntegerState show;

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

	// comment for getter related to [name] goes here
	@GetModelValue(key = "name")
	public String getName() {		
		return name;
	}

	// comment for setter related to [show] goes here
	@SetModelValue(key = "show")
	public void setShow(IntegerState show) {
		this.show = show;
	}

	// comment for getter related to [show] goes here
	@GetModelValue(key = "show")
	public IntegerState getShow() {
		return show;
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
		builder.append(show);
		builder.append(", format=");
		builder.append(format);
		builder.append("]");
		return builder.toString();
	}

}
