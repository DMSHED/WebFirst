package com.http.util;

public final class UrlPath {
    public static final String LOGIN = "/login";
    public static final String REGISTRATION = "/registration";
    public static final String IMAGES = "/images";

    private UrlPath() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
