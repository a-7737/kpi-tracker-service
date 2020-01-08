package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.Team;
import com.ibs.kpitrackerservice.respository.TeamRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeamService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    private TeamRepository teamRepository;

    public Team getTeam(String id) {
        final var existingTeam = teamRepository.findById(id);
        if (existingTeam.isEmpty()) {
            LOGGER.warn(Events.getMessage(Events.TEAM_NOT_FOUND));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Events.getMessage(Events.TEAM_NOT_FOUND));
        } else {
            return existingTeam.get();
        }
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team addTeam(Team team) {
        return teamRepository.insert(team);
    }

    public String updateTeam(Team updatedTeam) {
        final var existingTeam = getTeam(updatedTeam.getId());
        updatedTeam.setId(new ObjectId(existingTeam.getId()));
        teamRepository.save(updatedTeam);
        LOGGER.info(Events.getMessage(Events.OPERATION_SUCCESSFUL));
        return Events.getMessage(Events.OPERATION_SUCCESSFUL);
    }

    public String deleteTeam(String id) {
        teamRepository.delete(getTeam(id));
        LOGGER.info(Events.getMessage(Events.OPERATION_SUCCESSFUL));
        return Events.getMessage(Events.OPERATION_SUCCESSFUL);
    }
}
