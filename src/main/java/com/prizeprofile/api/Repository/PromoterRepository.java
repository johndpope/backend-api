package com.prizeprofile.api.Repository;

import com.prizeprofile.api.Entity.Promoter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PromoterRepository extends JpaRepository<Promoter, Long> {
    //
}