package io.github.d2edev.ccc.api;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes key in query which value should be passed to model's method  
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface SetModelValue {

	String key();
}
