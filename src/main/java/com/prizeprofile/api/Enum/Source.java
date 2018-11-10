package com.prizeprofile.api.Enum;

public enum Source {
    TWITTER(0),
    GLEAM(1)
    ;

    private Integer sourceId;

    Source(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getId() {
        return sourceId;
    }
}
