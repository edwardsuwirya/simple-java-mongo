package com.enigmacamp.tutorial.usecase;

import com.enigmacamp.tutorial.exception.MandatoryParameterException;
import com.enigmacamp.tutorial.repository.DynamicQuery;
import com.enigmacamp.tutorial.repository.TraineeRepository;
import com.enigmacamp.tutorial.repository.model.Trainee;
import com.enigmacamp.tutorial.repository.model.TraineeCountResult;
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

    public List<Trainee> call(DynamicQuery dynamicQuery) throws MandatoryParameterException {
        return traineeRepository.query(dynamicQuery, null);
    }
}
