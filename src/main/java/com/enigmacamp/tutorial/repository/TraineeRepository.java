package com.enigmacamp.tutorial.repository;

import com.enigmacamp.tutorial.repository.model.Trainee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TraineeRepository extends MongoRepository<Trainee, String>,TraineeRepositoryCustom {
//    @Query("{_id:'?0'}")
//    Trainee findById(String id);

    long count();
}
