package com.prizeprofile.api.Specification;


import com.prizeprofile.api.Entity.Competition;
import com.prizeprofile.api.Entity.Competition_;
import com.prizeprofile.api.Entity.Promoter;
import com.prizeprofile.api.Entity.Promoter_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


public class CompetitionSpecification implements Specification<Competition> {
    private SearchCriteria criteria;

    public CompetitionSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Competition> root, CriteriaQuery<?> query,
                                 CriteriaBuilder cb) {
        Join<Competition, Promoter> o = root.join(Competition_.promoter);
        Path<Promoter> promoter = root.get(Competition_.promoter);
        Path<Boolean> verified = promoter.get(Promoter_.verified);
        Path<Integer> entrants = root.get(Competition_.retweets);

        final List<Predicate> predicates = new ArrayList<>();

        if (criteria.getEntrants() != null) {
            Integer entrantsLimit = criteria.getEntrants();

            boolean _pushed = entrantsLimit > 999
                ? predicates.add(cb.greaterThan(entrants, entrantsLimit))
                : predicates.add(cb.lessThan(entrants, entrantsLimit));
        }

        if (criteria.getOnlyVerified() != null) {
            predicates.add(cb.isTrue(verified));
        }

        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}