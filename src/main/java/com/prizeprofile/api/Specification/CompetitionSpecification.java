package com.prizeprofile.api.Specification;


import com.prizeprofile.api.Entity.Competition;
import com.prizeprofile.api.Entity.Competition_;
import com.prizeprofile.api.Entity.Promoter;
import com.prizeprofile.api.Entity.Promoter_;
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
            onlyVerified(predicates);
            minEntrants(predicates);
            maxEntrants(predicates);
            onlyRecent(predicates);
            onlyActive(predicates);
            filterMethods(predicates);
            filterPattern(predicates);
        }

        return builder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    /**
     * Filters out competitions that are most likely still active.
     *
     * @param predicates Holds the query shards.
     */
    private void onlyActive(List<Predicate> predicates) {
        Date postedFrom = java.sql.Date.valueOf(LocalDate.now().minusDays(5));
        Date endingFrom = java.sql.Date.valueOf(LocalDate.now().minusDays(1));

        Path<Date> posted = root.get(Competition_.posted);
        Path<Date> ending = root.get(Competition_.endDate);

        predicates.add(builder.or(
            builder.greaterThanOrEqualTo(posted, postedFrom),
            builder.greaterThanOrEqualTo(ending, endingFrom)
        ));
    }

    private void onlyVerified(List<Predicate> predicates) {
        if (criteria.getOnlyVerified() != null && criteria.getOnlyVerified()) {
            Path<Boolean> verified = promoter.get(Promoter_.verified);
            predicates.add(builder.isTrue(verified));
        }
    }

    /**
     * Filters competitions based on entrants.
     *
     * @param predicates Holds the query shards.
     */
    private void maxEntrants(List<Predicate> predicates) {
        Integer maxEntrants = criteria.getMaxEntrants();

        if (maxEntrants != null) {
            Path<Integer> entrants = root.get(Competition_.retweets);

            predicates.add(builder.lessThan(entrants, maxEntrants));
        }
    }

    /**
     * Filters competitions based on entrants.
     *
     * @param predicates Holds the query shards.
     */
    private void minEntrants(List<Predicate> predicates) {
        Integer minEntrants = criteria.getMinEntrants();

        if (minEntrants != null) {
            Path<Integer> entrants = root.get(Competition_.retweets);

            predicates.add(builder.greaterThanOrEqualTo(entrants, minEntrants));
        }
    }

    /**
     * Filters competitions based on entry methods.
     * TODO: Refactor as this approach is slow.
     *
     * @param predicates Holds the query shards.
     */
    private void filterMethods(List<Predicate> predicates) {
        if (criteria.getEntryMethods() != null) {
            Path<String> methods = root.get("entryMethods");
            String[] requestedMethods = criteria.getEntryMethods().split(",");

            Arrays.stream(requestedMethods)
                .filter(EntryMethod::exists)
                .forEach((method) -> {
                    predicates.add(builder.greaterThan(builder.locate(methods, method), 0));
                });
        }
    }

    /**
     * Shows only competitions from last 24 hours.
     *
     * @param predicates Holds the query shards.
     */
    private void onlyRecent(List<Predicate> predicates) {
        if (criteria.getOnlyRecent() != null) {
            Date date = java.sql.Date.valueOf(LocalDate.now().minusDays(1));
            Path<Date> posted = root.get(Competition_.posted);

            predicates.add(builder.greaterThanOrEqualTo(posted, date));
        }
    }

    /**
     * Fulltext search.
     * TODO: Refactor case insensitive search.
     *
     * @param predicates Holds the query shards.
     */
    private void filterPattern(List<Predicate> predicates) {
        if (criteria.getPattern() != null) {
            String pattern = criteria.getPattern().toLowerCase();
            Path<String> text = root.get(Competition_.text);
            Path<String> screenName = promoter.get(Promoter_.screenName);
            Path<String> name = promoter.get(Promoter_.name);

            predicates.add(builder.or(
                builder.like(builder.lower(text), "%" + pattern + "%"),
                builder.like(builder.lower(screenName), "%" + pattern + "%"),
                builder.like(builder.lower(name), "%" + pattern + "%")
            ));
        }
    }
}
