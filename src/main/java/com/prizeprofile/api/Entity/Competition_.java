package com.prizeprofile.api.Entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Competition.class)
public class Competition_ {
    public static volatile SingularAttribute<Competition, Promoter> promoter;

    public static volatile SingularAttribute<Competition, Integer> retweets;
}
