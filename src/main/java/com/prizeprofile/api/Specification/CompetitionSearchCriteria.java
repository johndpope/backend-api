package com.prizeprofile.api.Specification;

public class CompetitionSearchCriteria {
    private Integer entrants;

    private Boolean onlyVerified;

    private String entryMethods;

    private Boolean onlyRecent;

    private String pattern;

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

    public String getEntryMethods() {
        return entryMethods;
    }

    public void setEntryMethods(String entryMethods) {
        this.entryMethods = entryMethods;
    }

    public Boolean getOnlyRecent() {
        return onlyRecent;
    }

    public void setOnlyRecent(Boolean onlyRecent) {
        this.onlyRecent = onlyRecent;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
