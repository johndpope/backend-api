package com.prizeprofile.api.Enum;

public enum EntryMethod {
    LIKE,
    COMMENT,
    FRIEND,
    RETWEET,
    FOLLOW,
    TWITCHTV_FOLLOW,
    TWITCHTV_SUBSCRIBE,
    DISCORD_JOIN_SERVER
    ;

    public static Boolean exists(String method) {
        try {
            EntryMethod.valueOf(method.toUpperCase());

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String toString() {
        return this.name().toLowerCase();
    }
}
