package com.prizeprofile.api.Enum;

public enum EntryMethod {
    LIKE("like"),
    COMMENT("comment"),
    MENTION("mention"),
    RETWEET("retweet"),
    FOLLOW("follow")
    ;

    private final String method;

    EntryMethod(final String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return method;
    }
}
