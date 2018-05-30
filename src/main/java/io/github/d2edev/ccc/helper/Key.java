package io.github.d2edev.ccc.helper;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Helper annotation which marks fields in reply, later getters and setters will be generated using annotated fields 
 * @author ddmitry
 *
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Key {
	String value();
}
