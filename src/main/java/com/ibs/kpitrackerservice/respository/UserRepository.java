package com.ibs.kpitrackerservice.respository;

import com.ibs.kpitrackerservice.model.Team;
import com.ibs.kpitrackerservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findById(String id);

    Optional<User> findByEmployeeName(String name);

    Optional<User> findUserByUserNameAndPassword(String userName, String password);

    List<User> findByTeam(Team team);

    List<User> findByPrivilege(String privilege);

    List<User> findAll();

    User save(User user);

    User insert(User User);

    void delete(User User);

}
