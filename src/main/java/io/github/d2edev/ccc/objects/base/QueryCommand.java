package io.github.d2edev.ccc.objects.base;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Describes command to be used in query
 * i.e @QueryCommand("getvideoattr") gives "...?cmd=getvideoattr.."
 * after marshalling
 * @author ddmitry
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface QueryCommand {

	String value();
	
}
