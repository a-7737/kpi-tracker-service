package com.ibs.kpitrackerservice.respository;

import com.ibs.kpitrackerservice.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {

    Optional<Team> findById(String id);

    List<Team> findAll();

    Team save(Team team);

    Team insert(Team team);

    void delete(Team team);
}
