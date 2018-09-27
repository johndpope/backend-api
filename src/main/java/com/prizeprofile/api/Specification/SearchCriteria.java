package com.prizeprofile.api.Specification;

public class SearchCriteria {
    private Integer entrants;

    private Boolean onlyVerified;

    public Integer getEntrants() {
        return entrants;
    }

    public void setEntrants(Integer entrants) {
        this.entrants = entrants;
    }

    public Boolean getOnlyVerified() {
        return onlyVerified;
    }

    public void setOnlyVerified(Boolean verified) {
        this.onlyVerified = verified;
    }
}
