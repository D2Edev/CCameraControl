package io.github.d2edev.ccc.api;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Describes command to be used in query after marshalling
 * i.e @QueryCommand("getvideoattr") gives "...?cmd=getvideoattr.."
 * @author ddmitry
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface CamRequest {

	public static final String PARAM_ENDPOINT = "/cgi-bin/hi3510/param.cgi?";
	
	String cmd() default "";
	String endpoint() default PARAM_ENDPOINT;
	
}
