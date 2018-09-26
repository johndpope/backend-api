package com.prizeprofile.api.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {
    @Column(name = "tweet_id")
    @JsonProperty("tweet_id")
    private String tweetId;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posted;

    @Column(name = "end_date", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("end_date")
    private Date endDate;

    @Type(type = "jsonb")
    @Column(name = "entry_methods", columnDefinition = "jsonb")
    @JsonProperty("entry_methods")
    private List<String> entryMethods;

    @ManyToOne
    @JoinColumn(name = "promoter_id")
    private Promoter promoter;

    private String text;

    private String preview;

    private Integer retweets;

    private Integer favorites;

    private Integer comments;

    public String getTweetId() {
        return tweetId;
    }

    public Date getPosted() {
        return posted;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<String> getEntryMethods() {
        return entryMethods;
    }

    public Promoter getPromoter() {
        return promoter;
    }

    public String getText() {
        return text;
    }

    public String getPreview() {
        return preview;
    }

    public Integer getRetweets() {
        return retweets;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public Integer getComments() {
        return comments;
    }
}
