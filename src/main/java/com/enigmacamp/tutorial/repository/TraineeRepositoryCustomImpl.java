package com.enigmacamp.tutorial.repository;

import com.enigmacamp.tutorial.DynamicSort;
import com.enigmacamp.tutorial.exception.MandatoryParameterException;
import com.enigmacamp.tutorial.repository.model.Trainee;
import com.enigmacamp.tutorial.repository.model.TraineeCountResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

public class TraineeRepositoryCustomImpl implements TraineeRepositoryCustom {
    private MongoTemplate mongoTemplate;

    @Autowired
    public TraineeRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    private Optional<Query> queryBuilder(DynamicQuery dynamicQuery, DynamicSort dynamicSort) {
        Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        if (dynamicQuery.getFirstNameLike() != null) {
            criteria.add(Criteria.where("firstName").regex(dynamicQuery.getFirstNameLike(), "i"));
        }
        if (dynamicQuery.getLastNameLike() != null) {
            criteria.add(Criteria.where("lastName").regex(dynamicQuery.getLastNameLike(), "i"));
        }
        if (dynamicQuery.getFirstNameStartWith() != null) {
            criteria.add(Criteria.where("firstName").regex("^" + dynamicQuery.getFirstNameStartWith(), "i"));
        }
        if (dynamicQuery.getLastNameStartWith() != null) {
            criteria.add(Criteria.where("lastName").regex("^" + dynamicQuery.getLastNameStartWith(), "i"));
        }
        if (dynamicQuery.getJoinDateBefore() != null) {
            criteria.add(Criteria.where("joinDate").lte(dynamicQuery.getJoinDateBefore()));
        }
        if (dynamicQuery.getJoinDateAfter() != null) {
            criteria.add(Criteria.where("joinDate").gte(dynamicQuery.getJoinDateAfter()));
        }
        if (dynamicSort != null) {
            query.with(dynamicSort.sort());
        }
        if (!criteria.isEmpty()) {
            return Optional.of(query.addCriteria(new Criteria().andOperator(criteria)));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Trainee> query(DynamicQuery dynamicQuery, DynamicSort dynamicSort) throws MandatoryParameterException {
        Optional<Query> opt = queryBuilder(dynamicQuery, dynamicSort);
        if (opt.isPresent()) {
            return mongoTemplate.find(opt.get(), Trainee.class);
        } else {
            throw new MandatoryParameterException("Query field");
        }

    }

    @Override
    public List<TraineeCountResult> queryCountGroup(String groupBy) {
        GroupOperation groupStage = group(groupBy).count().as("totalCount");
        ProjectionOperation projectStage = project().andExclude("_id").and("_id").as(groupBy).and("totalCount").as("totalCount");
        SortOperation sortStage = sort(Sort.Direction.ASC, groupBy);
        Aggregation agg = newAggregation(groupStage, projectStage, sortStage);
        AggregationResults<TraineeCountResult> groupResults
                = mongoTemplate.aggregate(agg, Trainee.class, TraineeCountResult.class);
        return groupResults.getMappedResults();
    }
}
