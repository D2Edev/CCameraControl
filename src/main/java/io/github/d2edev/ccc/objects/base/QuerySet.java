package io.github.d2edev.ccc.objects.base;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marks variable that keeps some data set used in request or returned from response
 * @author ddmitry
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface QuerySet {

}
