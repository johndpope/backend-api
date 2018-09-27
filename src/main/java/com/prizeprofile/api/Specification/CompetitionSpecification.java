package com.prizeprofile.api.Specification;


import com.prizeprofile.api.Entity.Competition;
import com.prizeprofile.api.Entity.ShadowMapping.Competition_;
import com.prizeprofile.api.Entity.Promoter;
import com.prizeprofile.api.Entity.ShadowMapping.Promoter_;
import com.prizeprofile.api.Enum.EntryMethod;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CompetitionSpecification implements Specification<Competition> {
    private CompetitionSearchCriteria criteria;

    private CriteriaBuilder builder;

    private Root<Competition> root;

    private Path<Promoter> promoter;

    public CompetitionSpecification(CompetitionSearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Competition> root, CriteriaQuery<?> query,
                                 CriteriaBuilder builder) {
        Join<Competition, Promoter> o = root.join(Competition_.promoter);
        this.root = root;
        this.builder = builder;
        this.promoter = root.get(Competition_.promoter);

        final List<Predicate> predicates = new ArrayList<>();
        {
            // onlyPastDay(predicates);
            // findPattern(predicates);
            isVerified(predicates);
            // limitEntrants(predicates);
            //filterMethods(predicates);
        }

        return builder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    private void isVerified(List<Predicate> predicates) {
        if (criteria.getOnlyVerified() != null && criteria.getOnlyVerified()) {
            Path<Boolean> verified = promoter.get(Promoter_.verified);
            predicates.add(builder.isTrue(verified));
        }
    }

    private void limitEntrants(List<Predicate> predicates) {
        if (criteria.getEntrants() != null) {
            Path<Integer> entrants = root.get(Competition_.retweets);
            Integer entrantsLimit = criteria.getEntrants();

            predicates.add(entrantsLimit > 999
                    ? builder.greaterThan(entrants, entrantsLimit)
                    : builder.lessThan(entrants, entrantsLimit));
        }
    }

    private void filterMethods(List<Predicate> predicates) {
        if (criteria.getEntryMethods() != null) {
            Path<String> methods = root.get("entry_methods");
            String[] requestedMethods = criteria.getEntryMethods().split(",");

            Arrays.stream(requestedMethods)
                    .filter(EntryMethod::exists)
                    .forEach(method -> predicates.add(builder.like(methods, method)));
        }
    }

    /*private void onlyPastDay(List<Predicate> predicates) {
        if (criteria.getOnlyPastDay() != null) {
            Date date = java.sql.Date.valueOf(LocalDate.now().minusDays(1));
            Path<Date> verified = root.get(Competition_.posted);

            predicates.add(builder.greaterThanOrEqualTo(verified, date));
        }
    }*/

    private void findPattern(List<Predicate> predicates) {
        if (criteria.getPattern() != null) {
            Path<String> text = root.get(Competition_.text);

            predicates.add(builder.like(text, "%" + criteria.getPattern() + "%"));
        }
    }
}
