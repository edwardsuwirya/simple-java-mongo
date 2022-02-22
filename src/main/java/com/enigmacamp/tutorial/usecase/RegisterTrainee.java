package com.enigmacamp.tutorial.usecase;

import com.enigmacamp.tutorial.repository.TraineeRepository;
import com.enigmacamp.tutorial.repository.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterTrainee {
    private TraineeRepository traineeRepository;

    @Autowired
    public RegisterTrainee(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public Trainee call(Trainee newTrainee) {
        return traineeRepository.save(newTrainee);
    }

    public List<Trainee> call(List<Trainee> newTrainee) {
        return traineeRepository.saveAll(newTrainee);
    }
}
