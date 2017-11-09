package io.github.d2edev.ccc.api;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/** 
 * Denotes method which result should be put as parameter named after key in query 
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface GetModelValue {

	String key();
}
