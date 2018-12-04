package com.prizeprofile.api.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {
    @Column(name = "resource_id")
    @JsonProperty("resource_id")
    private String resourceId;

    @Column(name = "source_id")
    @JsonProperty("source_id")
    private Integer sourceId;

    @Column(name = "region_id")
    @JsonProperty("region_id")
    private Integer regionId;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posted;

    @Column(name = "end_date", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("end_date")
    private Date endDate;

    @Type(type = "json")
    @Column(name = "entry_methods", columnDefinition = "json")
    @JsonProperty("entry_methods")
    private List<String> entryMethods;

    @ManyToOne
    @JoinColumn(name = "promoter_id")
    private Promoter promoter;

    private String text;

    private String preview;

    private Integer entrants;

    public String getResourceId() {
        return resourceId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public Integer getRegionId() {
        return regionId;
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

    public Integer getEntrants() {
        return entrants;
    }
}
