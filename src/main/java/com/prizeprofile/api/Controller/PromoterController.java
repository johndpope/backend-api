package com.prizeprofile.api.Controller;

import com.prizeprofile.api.Entity.Competition;
import com.prizeprofile.api.Entity.Promoter;
import com.prizeprofile.api.Exception.ResourceNotFoundException;
import com.prizeprofile.api.Repository.CompetitionRepository;
import com.prizeprofile.api.Repository.PromoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/promoters")
public class PromoterController {
    @Autowired
    private PromoterRepository promoterRepository;

    @Autowired
    private CompetitionRepository competitionRepository;

    @GetMapping()
    public @ResponseBody Iterable<Promoter> getAllCompetitions() {
        return promoterRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Promoter getCompetition(@PathVariable Long id) {
        return promoterRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/{id}/competitions")
    public @ResponseBody Iterable<Competition> getAllCompetitionsByPromoterId(@PathVariable Long id,
                                                                              Pageable pageable) {
        return competitionRepository.findByPromoterId(id, pageable);
    }
}
