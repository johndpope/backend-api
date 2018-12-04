package com.prizeprofile.api.Entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(BaseEntity.class)
public class BaseEntity_ {
    public static volatile SingularAttribute<Competition, Date> createdAt;
}
