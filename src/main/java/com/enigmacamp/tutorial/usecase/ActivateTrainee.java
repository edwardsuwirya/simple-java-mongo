package com.enigmacamp.tutorial.usecase;

import com.enigmacamp.tutorial.exception.DataNotFoundException;
import com.enigmacamp.tutorial.repository.TraineeRepository;
import com.enigmacamp.tutorial.repository.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ActivateTrainee {
    private TraineeRepository traineeRepository;

    @Autowired
    public ActivateTrainee(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public Trainee call(String id) throws DataNotFoundException {
        Optional<Trainee> opt = traineeRepository.findById(id);
        if (opt.isPresent()) {
            Trainee trainee = opt.get();
            trainee.setIsActive(1);
            return traineeRepository.save(trainee);
        } else {
            throw new DataNotFoundException(id);
        }
    }

}
