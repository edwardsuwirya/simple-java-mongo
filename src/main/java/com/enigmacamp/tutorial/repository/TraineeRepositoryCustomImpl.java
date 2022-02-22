package com.enigmacamp.tutorial.repository;

import com.enigmacamp.tutorial.DynamicSort;
import com.enigmacamp.tutorial.repository.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TraineeRepositoryCustomImpl implements TraineeRepositoryCustom {
    private MongoTemplate mongoTemplate;

    @Autowired
    public TraineeRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Trainee> query(DynamicQuery dynamicQuery, DynamicSort dynamicSort) {
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
            query.addCriteria(new Criteria().andOperator(criteria));
        }

        return mongoTemplate.find(query, Trainee.class);
    }
}
