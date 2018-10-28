package com.prizeprofile.api.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "promoters")
public class Promoter extends BaseEntity {
    @Column(name = "resource_id")
    @JsonProperty("resource_id")
    private String resourceId;

    @Column(name = "screen_name")
    @JsonProperty("screen_name")
    private String screenName;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "promoter"
    )
    private Set<Competition> competitions;

    private String thumbnail;

    private Integer followers;

    private String name;

    private Boolean verified;

    private String description;

    private String homepage;

    public String getReourceId() {
        return resourceId;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Integer getFollowers() {
        return followers;
    }

    public String getName() {
        return name;
    }

    public Boolean getVerified() {
        return verified;
    }

    public String getDescription() {
        return description;
    }

    public String getHomepage() {
        return homepage;
    }
}
