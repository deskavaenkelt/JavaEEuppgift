package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.models.Users;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserLogin {

    // Inject Models
    @Inject
    Users users;

    @PersistenceContext(unitName = "VaderAktivitetPU")
    private EntityManager entityManager;

    public List<Users> getAllUsers() {
        Query query = entityManager.createQuery("SELECT userName FROM Users");
        return query.getResultList();
    }

    public Users findUserByUserName(int searchForId) {
        // return one user.object
        return entityManager.find(Users.class, searchForId);
    }

    public Users createNewUser(Users users) {
        // Persist into DB
        entityManager.persist(users);
        return users;
    }
}

