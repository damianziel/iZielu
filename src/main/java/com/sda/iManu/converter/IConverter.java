package com.sda.iManu.converter;


public interface IConverter<T, U> {

    U convert(T t);
}
