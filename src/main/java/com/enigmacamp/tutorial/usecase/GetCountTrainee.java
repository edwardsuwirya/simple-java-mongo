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
public class GetCountTrainee {
    private TraineeRepository traineeRepository;

    @Autowired
    public GetCountTrainee(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }


    public List<TraineeCountResult> call(String groupBy) {
        return traineeRepository.queryCountGroup(groupBy);
    }
}
