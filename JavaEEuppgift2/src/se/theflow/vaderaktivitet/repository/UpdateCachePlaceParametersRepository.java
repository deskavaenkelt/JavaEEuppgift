package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.models.CachePlaceParametersModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class UpdateCachePlaceParametersRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VaderAktivitetPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @PersistenceContext(unitName = "VaderAktivitetPU")
    EntityManager em;

    // id[1] -> id[30]
    public void updatePlaces(int id, int temperature, int cloud, int wind) {
        System.out.println("inside updatePlaces");
        entityManager.getTransaction().begin();
        CachePlaceParametersModel updateGothenburg = em.find(CachePlaceParametersModel.class, id);

        updateGothenburg.setTemperature(temperature);
        updateGothenburg.setCloud(cloud);
        updateGothenburg.setWind(wind);
        entityManager.getTransaction().commit();
    }
}
