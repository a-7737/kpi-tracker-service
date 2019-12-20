package com.ibs.kpitrackerservice.controller;

import com.ibs.kpitrackerservice.model.Team;
import com.ibs.kpitrackerservice.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(path = "/kpi")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(path = "/team/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable("id") String id) {
        return ResponseEntity.ok(teamService.getTeam(id).get());
    }

    @GetMapping(path = "/team")
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());

    }

    @PostMapping(path = "/team")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return ResponseEntity.ok(teamService.addTeam(team));

    }

    @PutMapping(path = "/team/{id}")
    public ResponseEntity<String> updateTeam(@PathVariable("id") String id, @RequestBody Team team) {
        return ResponseEntity.ok(teamService.updateTeam(id, team));

    }

    @DeleteMapping(path = "/team/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable("id") String id) {
        return ResponseEntity.ok(teamService.deleteTeam(id));
    }


}
