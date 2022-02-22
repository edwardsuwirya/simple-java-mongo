package com.enigmacamp.tutorial.repository;

import com.enigmacamp.tutorial.DynamicSort;
import com.enigmacamp.tutorial.repository.DynamicQuery;
import com.enigmacamp.tutorial.repository.model.Trainee;

import java.util.List;

public interface TraineeRepositoryCustom {
    List<Trainee> query(DynamicQuery dynamicQuery, DynamicSort dynamicSort);
}
