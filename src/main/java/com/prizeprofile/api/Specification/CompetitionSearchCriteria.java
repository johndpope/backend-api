package com.prizeprofile.api.Specification;

public class CompetitionSearchCriteria {
    private Integer entrants;

    private Boolean onlyVerified;

    private String entryMethods;

    private Boolean onlyPastDay;

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

    public Boolean getOnlyPastDay() {
        return onlyPastDay;
    }

    public void setOnlyPastDay(Boolean onlyPastDay) {
        this.onlyPastDay = onlyPastDay;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
