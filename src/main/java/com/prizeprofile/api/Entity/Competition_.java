package com.prizeprofile.api.Entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Competition.class)
public class Competition_ {
    public static volatile SingularAttribute<Competition, Integer> sourceId;

    public static volatile SingularAttribute<Competition, Integer> regionId;

    public static volatile SingularAttribute<Competition, Promoter> promoter;

    public static volatile SingularAttribute<Competition, Integer> entrants;

    public static volatile SingularAttribute<Competition, Date> posted;

    public static volatile SingularAttribute<Competition, Date> createdAt;

    public static volatile SingularAttribute<Competition, Date> endDate;

    public static volatile SingularAttribute<Competition, String> text;
}
