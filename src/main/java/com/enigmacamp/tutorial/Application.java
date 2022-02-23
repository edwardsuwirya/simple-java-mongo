package com.enigmacamp.tutorial;

import com.enigmacamp.tutorial.exception.DataNotFoundException;
import com.enigmacamp.tutorial.repository.model.Trainee;
import com.enigmacamp.tutorial.repository.model.TraineeCountResult;
import com.enigmacamp.tutorial.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

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

    @Autowired
    private ActivateTrainee activateTrainee;

    @Autowired
    private GetCountTrainee getCountTrainee;

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
//                    new Trainee("Kenji", "", 24, new Date(), 0),
//                    new Trainee("Kenneth", "Parulian", 25, new Date(), 0)
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

//            Update status trainee
//            try {
//                Trainee trainee = activateTrainee.call("6215871591d40f79b60e0a4c");
//                System.out.println(trainee.toString());
//            } catch (DataNotFoundException e) {
//                System.out.println("Trainee not found");
//            }

//            DynamicQuery dynamicQuery = new DynamicQuery();
//            dynamicQuery.setLastNameStartWith("a");
//            DynamicSort dynamicSort = new DynamicSort("age", Sort.Direction.ASC);
//            List<Trainee> trainees = findTrainee.call(dynamicQuery, dynamicSort);
//            for (Trainee trainee : trainees) {
//                System.out.println(trainee.getId() + " " + trainee.getFirstName() + " " + trainee.getLastName() + " " + trainee.getAge());
//            }
            List<TraineeCountResult> countResultList = getCountTrainee.call("age");
            for (TraineeCountResult c : countResultList) {
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            System.out.println("Failed " + e);
        }
    }
}
