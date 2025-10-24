package com.example.demo;

import com.example.demo.models.Team;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "https://fullstackkin.netlify.app/")
public class CaplController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/cards")
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/team")
    public Team getTeamDetails(@RequestParam String name) {
        return teamRepository.findByNameIgnoreCase(name)
                .orElse(new Team("Unknown", "Team not found", "#333333", ""));
    }

    @PostMapping("/team")
    public String addTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return "Team added successfully";
    }

    @PutMapping("/team")
    public String updateTeam(@RequestBody Team updatedTeam) {
        Optional<Team> existing = teamRepository.findByNameIgnoreCase(updatedTeam.getName());
        if (existing.isPresent()) {
            Team team = existing.get();
            team.setMotto(updatedTeam.getMotto());
            team.setColor(updatedTeam.getColor());
            team.setImage(updatedTeam.getImage());
            teamRepository.save(team);
            return "Team updated successfully";
        } else {
            return "Team not found";
        }
    }

    @DeleteMapping("/team")
    public String deleteTeam(@RequestParam String name) {
        Optional<Team> existing = teamRepository.findByNameIgnoreCase(name);
        if (existing.isPresent()) {
            teamRepository.delete(existing.get());
            return "Team deleted successfully";
        } else {
            return "Team not found";
        }
    }
}