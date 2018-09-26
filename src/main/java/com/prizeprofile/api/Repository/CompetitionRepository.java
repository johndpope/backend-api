package com.prizeprofile.api.Repository;

import com.prizeprofile.api.Entity.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CompetitionRepository extends CrudRepository<Competition, Integer> {
    Page<Competition> findAll(Pageable pageable);

    Page<Competition> findByPromoterId(Integer promoterId, Pageable pageable);
}