package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.Team;
import com.ibs.kpitrackerservice.respository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Optional<Team> getTeam(String id) {
        return teamRepository.findById(id);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team addTeam(Team team) {
        return teamRepository.insert(team);
    }

    public String updateTeam(String id, Team team) {
        Optional<Team> existingTeam = getTeam(id);
        if (existingTeam.isEmpty()) {
            return Events.getMessage(Events.OPERATION_FAILED);
        } else {
            Team updatedTeam = existingTeam.get();
            updatedTeam.setName(team.getName());
            teamRepository.save(updatedTeam);
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
    }

    public String deleteTeam(String id) {
        Optional<Team> team = getTeam(id);

        if (team.isEmpty()) {
            return Events.getMessage(Events.OPERATION_FAILED);
        } else {
            teamRepository.delete(team.get());
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
    }
}
