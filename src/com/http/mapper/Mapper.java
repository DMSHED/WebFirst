package com.http.mapper;

public interface Mapper<F,T> {
    T mapFrom(F object);
}
