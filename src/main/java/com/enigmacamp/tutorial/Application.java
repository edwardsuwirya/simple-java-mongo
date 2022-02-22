package com.enigmacamp.tutorial;

import com.enigmacamp.tutorial.repository.DynamicQuery;
import com.enigmacamp.tutorial.repository.model.Trainee;
import com.enigmacamp.tutorial.usecase.FindTrainee;
import com.enigmacamp.tutorial.usecase.GetTotalTrainee;
import com.enigmacamp.tutorial.usecase.RegisterTrainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.enigmacamp.tutorial"})
public class Application implements CommandLineRunner {
    @Autowired
    private RegisterTrainee registerTrainee;

    @Autowired
    private FindTrainee findTrainee;

    @Autowired
    private GetTotalTrainee getTotalTrainee;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Java Mongo");
//            Single Insert
//            Trainee registeredUser = registerTrainee.call(new Trainee("Joko", "Anwar", 30, new Date(), 0));

//            Bulk Insert
//            List<Trainee> registeredUser = registerTrainee.call(List.of(
//                    new Trainee("Budi", "Anduk", 29, new Date(), 0),
//                    new Trainee("David", "Budiman", 31, new Date(), 0)
//            ));
//            System.out.println(registeredUser.size());

//            Find by ID Mongo
//            Trainee trainee = findTrainee.call("62146314773656727cb7aa96");
//            System.out.println(trainee.toString());

//            Total Trainee
//            System.out.println("Total " + getTotalTrainee.call());

//            DynamicQuery dynamicQuery = new DynamicQuery();
//            dynamicQuery.setFirstNameLike("budi");
//
//            List<Trainee> trainees = findTrainee.call(dynamicQuery);
//            for (Trainee trainee : trainees) {
//                System.out.println(trainee.getId() + " " + trainee.getFirstName() + " " + trainee.getLastName());
//            }

            DynamicQuery dynamicQuery = new DynamicQuery();
            dynamicQuery.setLastNameStartWith("a");
            DynamicSort dynamicSort = new DynamicSort("age", Sort.Direction.ASC);
            List<Trainee> trainees = findTrainee.call(dynamicQuery, dynamicSort);
            for (Trainee trainee : trainees) {
                System.out.println(trainee.getId() + " " + trainee.getFirstName() + " " + trainee.getLastName() + " " + trainee.getAge());
            }
        } catch (Exception e) {
            System.out.println("Failed " + e);
        }
    }
}
