package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.models.Users;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

public class UserRepository {

    // Inject Models
    @Inject
    Users users;

    /*@Inject
    HashPasswordGenerator hashPasswordGenerator;*/

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VaderAktivitetPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @PersistenceContext(unitName = "VaderAktivitetPU")
    private EntityManager em;

    private String getUserNameById(int id) {
        Users users = entityManager.find(Users.class, id);
        return users.getUserName();
    }
    private String getUserSaltById(int id) {
        Users users = entityManager.find(Users.class, id);
        return users.getUserSalt();
    }
    private String getUserHashedPasswordById(int id) {
        Users users = entityManager.find(Users.class, id);
        return users.getUserPassword();
    }

    /*public List<Users> getAllUsers() {
        Query query = entityManager.createQuery("SELECT userName FROM users");
        return query.getResultList();
    }*/

    public int countUsersInTable() {
        int count = 0;

        for (int i = 0; i < 10; i++) {
            if (getUserNameById(i) == null) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    /*public List<Users> getAllUsers() {
        Query query = entityManager.createQuery("SELECT COUNT(x) FROM Users x");
        return query.getResultList();
    }*/

    public Users findUserByUserName(int searchForId) {
        // return one user.object
        return entityManager.find(Users.class, searchForId);
    }

    /*public Users createNewUser(String userName, String userPassword) {

        String generatedSalt = hashPasswordGenerator.generateASalt();
        String generatedHash = hashPasswordGenerator.generateHachedPassword(generatedSalt, userPassword);

        entityManager.getTransaction().begin();

        Users newUser = new Users();
        newUser.setUserName(userName);
        newUser.setUserSalt(generatedSalt);
        newUser.setUserPassword(generatedHash);

        // Persist into DB
        entityManager.persist(usersModel);
        entityManager.getTransaction().commit();


        return usersModel;
    }*/


}