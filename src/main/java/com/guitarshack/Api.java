package com.guitarshack;

public interface Api<T> {
    T get(String queryString);
    T post(String body, String authorisation);
}
