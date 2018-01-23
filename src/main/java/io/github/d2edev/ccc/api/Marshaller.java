package io.github.d2edev.ccc.api;

public interface Marshaller<I,O> {

	O marshall(I input) throws MarshallException;

}