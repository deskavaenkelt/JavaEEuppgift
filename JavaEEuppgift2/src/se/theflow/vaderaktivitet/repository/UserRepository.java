/*
package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.business.HashPasswordGenerator;
import se.theflow.vaderaktivitet.models.Users;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

public class UserRepository {

    // Inject Models
    @Inject
    Users users;

    @Inject
    HashPasswordGenerator hashPasswordGenerator;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VaderAktivitetPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @PersistenceContext(unitName = "VaderAktivitetPU")
    private EntityManager em;

    public List<Users> getAllUsers() {
        Query query = entityManager.createQuery("SELECT userName FROM Users");
        return query.getResultList();
    }

    public Users findUserByUserName(int searchForId) {
        // return one user.object
        return entityManager.find(Users.class, searchForId);
    }

    public Users createNewUser(String userName, String userPassword) {

        String generatedSalt = hashPasswordGenerator.generateASalt(userPassword);
        String generatedHash = hashPasswordGenerator.generateHachedPassword(generatedSalt, userPassword);

        entityManager.getTransaction().begin();

        Users newUser = new Users();
        newUser.setUserName(userName);
        newUser.setUserSalt(generatedSalt);
        newUser.setUserPassword(generatedHash);

        // Persist into DB
        entityManager.persist(users);
        entityManager.getTransaction().commit();


        return users;
    }


}

 */

