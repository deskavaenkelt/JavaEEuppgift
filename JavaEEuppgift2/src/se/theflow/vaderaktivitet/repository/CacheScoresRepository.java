package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.models.CacheScoresModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class CacheScoresRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VaderAktivitetPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @PersistenceContext(unitName = "VaderAktivitetPU")
    EntityManager em;

    // id[1] -> id[30]
    public void updateScores(int id, float fishing, float outdoorSeating, float sunBathing, float volleyBall, float windSurfing) {
        System.out.println("Update score " + id);

        entityManager.getTransaction().begin();
        CacheScoresModel updateScore = em.find(CacheScoresModel.class, id);
        updateScore.setFishing(fishing);
        updateScore.setOutdoorSeating(outdoorSeating);
        updateScore.setSunBathing(sunBathing);
        updateScore.setVolleyBall(volleyBall);
        updateScore.setWindSurfing(windSurfing);
        entityManager.getTransaction().commit();
    }

    public void updateFishing(int id, float fishing) {
        entityManager.getTransaction().begin();
        CacheScoresModel updateScore = em.find(CacheScoresModel.class, id);
        updateScore.setFishing(fishing);
        entityManager.getTransaction().commit();

    }

    public void updateOutdoorSeating(int id, float outdoorSeating) {
        entityManager.getTransaction().begin();
        CacheScoresModel updateScore = em.find(CacheScoresModel.class, id);
        updateScore.setOutdoorSeating(outdoorSeating);
        entityManager.getTransaction().commit();

    }

    public void updateSunBathing(int id, float sunBathing) {
        entityManager.getTransaction().begin();
        CacheScoresModel updateScore = em.find(CacheScoresModel.class, id);
        updateScore.setSunBathing(sunBathing);
        entityManager.getTransaction().commit();

    }

    public void updateVolleyBall(int id, float volleyBall) {
        entityManager.getTransaction().begin();
        CacheScoresModel updateScore = em.find(CacheScoresModel.class, id);
        updateScore.setVolleyBall(volleyBall);
        entityManager.getTransaction().commit();
    }

    public void updateWindSurfing(int id, float windSurfing) {
        entityManager.getTransaction().begin();
        CacheScoresModel updateScore = em.find(CacheScoresModel.class, id);
        updateScore.setWindSurfing(windSurfing);
        entityManager.getTransaction().commit();

    }
}
