package com.ibs.kpitrackerservice.respository;

import com.ibs.kpitrackerservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findById(String id);
}
