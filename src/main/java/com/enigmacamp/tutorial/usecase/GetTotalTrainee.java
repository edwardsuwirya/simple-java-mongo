package com.enigmacamp.tutorial.usecase;

import com.enigmacamp.tutorial.repository.TraineeRepository;
import com.enigmacamp.tutorial.repository.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTotalTrainee {
    private TraineeRepository traineeRepository;

    @Autowired
    public GetTotalTrainee(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public long call() {
        return traineeRepository.count();
    }

    public void call(String groupBy) {

    }
}
