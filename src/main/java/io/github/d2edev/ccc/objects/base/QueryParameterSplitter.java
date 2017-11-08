package io.github.d2edev.ccc.objects.base;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Used to split variable name from data set.
 * Some response returned contain data like "varname_N=value", where
 * N is data set number, i.e. "bps_1=512" or "fps_2=25". The value of divider (in case above it's "_")
 * needs to be put as annotation value for successful unmarshalling 
 * @author ddmitry
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface QueryParameterSplitter {
	String value();
}
