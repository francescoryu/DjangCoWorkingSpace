package ch.zli.m223.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.controller.AppUserController;
import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;

@IfBuildProfile("dev")
@ApplicationScoped
public class TestDataService {

  @Inject
  EntityManager entityManager;

  @Inject
  AppUserController appUserController;

  @Transactional
  void generateTestData(@Observes StartupEvent event) {

    var user1 = new AppUser();
    user1.setFirstName("John");
    user1.setLastName("Doe");
    user1.setEmail("max@muster.ch");
    user1.setAge(15);
    user1.setPassword("pass1");
    appUserController.create(user1);
    
    var user2 = new AppUser();
    user2.setFirstName("Alice");
    user2.setLastName("Smith");
    user2.setEmail("alice@example.com");
    user2.setAge(28);
    user2.setPassword("pass2");
    appUserController.create(user2);

    var user3 = new AppUser();
    user3.setFirstName("Michael");
    user3.setLastName("Johnson");
    user3.setEmail("michael@example.com");
    user3.setAge(40);
    user3.setPassword("pass3");
    appUserController.create(user3);

  }
}
