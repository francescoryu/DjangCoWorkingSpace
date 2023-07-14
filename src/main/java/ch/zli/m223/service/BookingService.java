package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Booking createBooking(Booking booking) {
        return entityManager.merge(booking);
    }

    @Transactional
    public Booking getBooking(Long id) {
        var entity = entityManager.find(Booking.class, id);
        return entity;
    }

    @Transactional
    public void deleteBooking (Long id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Booking updateBooking(Long id, Booking booking) {
        booking.setId(id);
        return entityManager.merge(booking);
    }

    public List<Booking> findAll(String email) {
        AppUser user = entityManager
                .createQuery("FROM AppUser WHERE email='" + email + "'", AppUser.class)
                .getSingleResult();
        if (!user.isAdmin()) {
            var query = entityManager.createQuery("FROM Booking WHERE user_id='" + user.getId().toString() + "'",
                    Booking.class);
            return query.getResultList();
        } else {
            var query = entityManager.createQuery("FROM Booking",
                    Booking.class);
            return query.getResultList();
        }
    }
}
