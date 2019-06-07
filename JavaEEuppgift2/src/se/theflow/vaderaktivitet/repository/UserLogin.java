package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.models.Users;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserLogin {

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

    public String findUserByUserIdReturnName(int searchForId) {
        Query queryCheck = entityManager.createQuery("SELECT userName FROM Users WHERE id = '" + searchForId + "'");
        return queryCheck.getResultList().toString();
    }
    /*public String findUserByUserIdReturnName2(int searchForId) {
        users.

        Query queryCheck = entityManager.createQuery("SELECT userName FROM Users WHERE id = '" + searchForId + "'");
        return queryCheck.getResultList().toString();
    }*/
    public String findUserByUserIdReturnSalt(int searchForId) {
        Query queryCheck = entityManager.createQuery("SELECT userSalt FROM Users WHERE id = '" + searchForId + "'");
        return queryCheck.getResultList().toString();
    }
    public String findUserByUserIdReturnPassword(int searchForId) {
        Query queryCheck = entityManager.createQuery("SELECT userPassword FROM Users WHERE id = '" + searchForId + "'");
        return queryCheck.getResultList().toString();
    }
}


/*
public boolean checkIfValidUser(String userName, String userPassword) {
        // Check if input is null
        if (userName == null || userPassword == null) {
            return false;
        }

        // Check if valid username
        if ("user".equals(username) && "password".equals(password)) {
            return;
        }


        return false;
    }
*/