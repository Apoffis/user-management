package com.user.usermanagement.service.utils;

public class SearchUtils {

    public static final int DEFAULT_FIRST_RESULT = 0;

    public static final int DEFAULT_MAX_RESULT = 10;

    private SearchUtils() {
        super();
    }

    public static int getDefaultFirstResult() {
        return DEFAULT_FIRST_RESULT;
    }

    public static int getDefaultMaxResult() {
        return DEFAULT_MAX_RESULT;
    }

}
