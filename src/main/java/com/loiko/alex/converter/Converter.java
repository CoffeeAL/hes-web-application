package com.loiko.alex.converter;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@FunctionalInterface
public interface Converter<T, U> {

    U convert(T object);
}