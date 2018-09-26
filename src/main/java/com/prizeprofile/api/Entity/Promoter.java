package com.prizeprofile.api.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "promoters")
public class Promoter extends BaseEntity {
    @Column(name = "twitter_id")
    @JsonProperty("twitter_id")
    private String twitterId;

    @Column(name = "screen_name")
    @JsonProperty("screen_name")
    private String screenName;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "promoter"
    )
    private Set<Competition> competition;

    private String thumbnail;

    private Integer followers;

    private String name;

    private Boolean verified;

    private String description;

    public String getTwitterId() {
        return twitterId;
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
}
