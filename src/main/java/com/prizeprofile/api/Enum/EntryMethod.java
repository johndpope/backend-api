package com.prizeprofile.api.Enum;

public enum EntryMethod {
    LIKE,
    COMMENT,
    MENTION,
    RETWEET,
    FOLLOW
    ;

    public static Boolean exists(String method) {
        try {
            EntryMethod.valueOf(method.toUpperCase());

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
