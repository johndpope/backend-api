package com.prizeprofile.api.Entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Promoter.class)
public class Promoter_ {
    public static volatile SingularAttribute<Promoter, Boolean> verified;

    public static volatile SingularAttribute<Promoter, String> screenName;

    public static volatile SingularAttribute<Promoter, String> name;
}
