package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.Team;
import com.ibs.kpitrackerservice.respository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamService.class);

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
        final Optional<Team> existingTeam = getTeam(id);
        if (existingTeam.isEmpty()) {
            LOGGER.warn(Events.TEAM_NOT_FOUND.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Events.TEAM_NOT_FOUND.toString());
        } else {
            Team updatedTeam = existingTeam.get();
            updatedTeam.setName(team.getName());
            teamRepository.save(updatedTeam);
            LOGGER.info(Events.OPERATION_SUCCESSFUL.toString());
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
    }

    public String deleteTeam(String id) {
        final Optional<Team> team = getTeam(id);

        if (team.isEmpty()) {
            LOGGER.warn(Events.TEAM_NOT_FOUND.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Events.TEAM_NOT_FOUND.toString());
        } else {
            teamRepository.delete(team.get());
            LOGGER.info(Events.OPERATION_SUCCESSFUL.toString());
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
    }
}
