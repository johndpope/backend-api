package com.prizeprofile.api.Controller;

import com.prizeprofile.api.Entity.Competition;
import com.prizeprofile.api.Exception.ResourceNotFoundException;
import com.prizeprofile.api.Repository.CompetitionRepository;
import com.prizeprofile.api.Specification.CompetitionSpecification;
import com.prizeprofile.api.Specification.CompetitionSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/competitions")
public class CompetitionController {
    @Autowired
    private CompetitionRepository competitionRepository;

    @GetMapping
    public @ResponseBody Iterable<Competition> getAllCompetitions(Pageable pageable,
                                                                  @ModelAttribute CompetitionSearchCriteria search) {
        System.out.println(search);
        CompetitionSpecification spec = new CompetitionSpecification(search);

        return competitionRepository.findAll(spec, pageable);
    }

    @GetMapping("/{id}")
    public @ResponseBody Competition getCompetition(@PathVariable Long id) {
        return competitionRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
