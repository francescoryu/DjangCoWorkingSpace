package ch.zli.m223.service;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.controller.AppUserController;
import ch.zli.m223.controller.BookingController;
import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Booking.Status;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;

@IfBuildProfile("dev")
@ApplicationScoped
public class TestDataService {

  @Inject
  EntityManager entityManager;

  @Inject
  AppUserController appUserController;

  @Inject
  BookingController bookingController;

  @Transactional
  void generateTestData(@Observes StartupEvent event) {

    var user1 = new AppUser();
    user1.setFirstName("John");
    user1.setLastName("Doe");
    user1.setEmail("max@muster.ch");
    user1.setAge(15);
    user1.setPassword("pass1");
    user1.setAdmin(true);
    entityManager.persist(user1);
    
    var user2 = new AppUser();
    user2.setFirstName("Alice");
    user2.setLastName("Smith");
    user2.setEmail("alice@example.com");
    user2.setAge(28);
    user2.setPassword("pass2");
    entityManager.persist(user2);

    var user3 = new AppUser();
    user3.setFirstName("Michael");
    user3.setLastName("Johnson");
    user3.setEmail("michael@example.com");
    user3.setAge(40);
    user3.setPassword("pass3");
    entityManager.persist(user3);
    
    //----------------------------------------------------------

    var booking1 = new Booking();
    booking1.setStartDate(LocalDateTime.now());
    booking1.setEndDate(LocalDateTime.now().plusDays(8));
    booking1.setStatus(Status.ACCEPTED);
    booking1.setWantsBeamer(true);
    booking1.setWantsNewsLetter(false);
    booking1.setDuration(15);
    booking1.setUser(user1);
    entityManager.persist(booking1);

    var booking2 = new Booking();
    booking2.setStartDate(LocalDateTime.now().plusDays(10));
    booking2.setEndDate(LocalDateTime.now().plusDays(15));
    booking2.setStatus(Status.PENDING);
    booking2.setWantsBeamer(false);
    booking2.setWantsNewsLetter(true);
    booking2.setDuration(15);
    booking2.setUser(user2);
    entityManager.persist(booking2);

    var booking4 = new Booking();
    booking4.setStartDate(LocalDateTime.now().plusDays(3));
    booking4.setEndDate(LocalDateTime.now().plusDays(7));
    booking4.setStatus(Status.DECLINED);
    booking4.setWantsBeamer(false);
    booking4.setWantsNewsLetter(true);
    booking4.setDuration(15);
    booking4.setUser(user3);
    entityManager.persist(booking4);


  }
}
