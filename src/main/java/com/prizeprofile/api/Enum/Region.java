package com.prizeprofile.api.Enum;

public enum Region {
    UK(1),
    USA(2),
    CA(3),
    AUS(4)
    ;

    private Integer regionId;

    Region(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getId() {
        return regionId;
    }
}
