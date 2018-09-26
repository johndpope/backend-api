package com.prizeprofile.api.Controller;

import com.prizeprofile.api.Entity.Competition;
import com.prizeprofile.api.Exception.ResourceNotFoundException;
import com.prizeprofile.api.Repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/competitions")
public class CompetitionController {
    @Autowired
    private CompetitionRepository competitionRepository;

    @GetMapping
    public @ResponseBody Iterable<Competition> getAllCompetitions(Pageable pageable) {
        return competitionRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public @ResponseBody Competition getCompetition(@PathVariable Integer id) {
        return competitionRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
