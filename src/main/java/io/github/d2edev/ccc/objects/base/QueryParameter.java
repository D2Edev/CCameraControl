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
	
	public static final String EMPTY="";

	/**
	 * maps to parameter name when processing response
	 * @return
	 */
	String get();
	/**
	 * should value be used in request generation, if 'false' - used only in response processing
	 * @return
	 */
	boolean out() default true;
	
	/**
	 * maps to parameter when creating request
	 * @return
	 */
	String set() default EMPTY;
	
}
