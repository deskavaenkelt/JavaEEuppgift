package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.models.Users;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class CreateNewUser {

    /*@Inject
    UserRepository userRepository;*/

    /*@Inject
    Users users;*/

    @Inject
    HashPasswordGenerator hashPasswordGenerator;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VaderAktivitetPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @PersistenceContext(unitName = "VaderAktivitetPU")
    private EntityManager em;

    public String createNewUser(String userName, String userPassword) {

        String generatedSalt = hashPasswordGenerator.generateASalt();
        String generatedHash = hashPasswordGenerator.generateHachedPassword(generatedSalt, userPassword);

        entityManager.getTransaction().begin();

        Users users = new Users();

        users.setUserName(userName);
        users.setUserSalt(generatedSalt);
        users.setUserPassword(generatedHash);

        // Persist into DB
        entityManager.persist(users);
        entityManager.getTransaction().commit();


        return "User created successfully!";
    }
}
