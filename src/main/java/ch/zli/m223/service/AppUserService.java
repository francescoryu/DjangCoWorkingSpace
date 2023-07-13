package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.AppUser;

@ApplicationScoped
public class AppUserService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public AppUser createUser(AppUser user) {
        if (findAll().size() == 0) {
            user.setAdmin(true);
        }
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        var entity = entityManager.find(AppUser.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public AppUser updateUser(Long id, AppUser user) {
        user.setId(id);
        return entityManager.merge(user);
    }

    public List<AppUser> findAll() {
        var query = entityManager.createQuery("FROM AppUser", AppUser.class);
        return query.getResultList();
    }

    public Optional<AppUser> findByEmail(String email) {
        return entityManager
                .createNamedQuery("AppUser.findByEmail", AppUser.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
