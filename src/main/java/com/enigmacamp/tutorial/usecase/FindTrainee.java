package com.enigmacamp.tutorial.usecase;

import com.enigmacamp.tutorial.DynamicSort;
import com.enigmacamp.tutorial.repository.DynamicQuery;
import com.enigmacamp.tutorial.repository.TraineeRepository;
import com.enigmacamp.tutorial.repository.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindTrainee {
    private TraineeRepository traineeRepository;

    @Autowired
    public FindTrainee(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public Trainee call(String id) {
        return traineeRepository.findById(id).orElse(null);
    }

    public List<Trainee> call(DynamicQuery dynamicQuery) {
        return traineeRepository.query(dynamicQuery, null);
    }

    public List<Trainee> call(DynamicQuery dynamicQuery, DynamicSort dynamicSort) {
        return traineeRepository.query(dynamicQuery, dynamicSort);
    }
}
