package io.github.d2edev.ccc.api;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 *  Marks method which accepts some model
 * @author ddmitry
 *
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface SetModel {

}
