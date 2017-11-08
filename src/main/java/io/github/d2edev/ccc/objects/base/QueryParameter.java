package io.github.d2edev.ccc.objects.base;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marks single parameter used in or extracted from query
 * @author ddmitry
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface QueryParameter {

	/**
	 * maps to parameter name in response/request
	 * @return
	 */
	String value();
	/**
	 * should value be used in request generation, if 'false' - used only in response processing
	 * @return
	 */
	boolean out() default true;
	
}
