package io.github.d2edev.ccc.api;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Describes command to be used in query after marshalling1
 * i.e @Request("getvideoattr") gives "...?cmd=getvideoattr.."
 * @author ddmitry
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Model {
	
	public static final String COMPLEX="complex";
	public static final String NETWORKLIST="net";
	public static final String SIMPLE="simple";
	public static final String BYTE = "byte";

	String value() default COMPLEX;
	
}
