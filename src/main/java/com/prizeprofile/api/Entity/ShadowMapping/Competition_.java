package com.prizeprofile.api.Entity.ShadowMapping;

import com.prizeprofile.api.Entity.Competition;
import com.prizeprofile.api.Entity.Promoter;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Competition.class)
public class Competition_ {
    public static volatile SingularAttribute<Competition, Promoter> promoter;

    public static volatile SingularAttribute<Competition, Integer> retweets;

    // public static volatile SingularAttribute<Competition, Date> posted;

    public static volatile SingularAttribute<Competition, String> text;
}
