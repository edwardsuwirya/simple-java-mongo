package com.enigmacamp.tutorial.repository;

import com.enigmacamp.tutorial.DynamicSort;
import com.enigmacamp.tutorial.exception.MandatoryParameterException;
import com.enigmacamp.tutorial.repository.model.Trainee;
import com.enigmacamp.tutorial.repository.model.TraineeCountResult;

import java.util.List;

public interface TraineeRepositoryCustom {
    List<Trainee> query(DynamicQuery dynamicQuery, DynamicSort dynamicSort) throws MandatoryParameterException;

    List<TraineeCountResult> queryCountGroup(String groupBy);
}
