package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.models.CachePlaceParametersModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class UpdateCachePlaceParametersRepository {

    //@Inject
    //CachePlaceParametersModel cacheGothenburgParameters;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VaderAktivitetPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @PersistenceContext(unitName = "VaderAktivitetPU")
    EntityManager em;

    // Göteborg day0 = id[1] , day5 = id[6]
    public void updateGoteborg(int id, int temperature, int cloud, int wind) {
        em.getTransaction().begin();
        CachePlaceParametersModel updateGothenburg = em.find(CachePlaceParametersModel.class, id);

        updateGothenburg.setTemperature(temperature);
        updateGothenburg.setCloud(cloud);
        updateGothenburg.setWind(wind);
    }

    // Kungsbacka day0 = id[7] , day5 = id[12]
    public void updateKungsbacka(int id, int temperature, int cloud, int wind) {
        entityManager.getTransaction().begin();
        CachePlaceParametersModel updateKungsbacka = entityManager.find(CachePlaceParametersModel.class, id);

        updateKungsbacka.setTemperature(temperature);
        updateKungsbacka.setCloud(cloud);
        updateKungsbacka.setWind(wind);
    }

    // Åsa day0 = id[13] , day5 = id[18]
    public void updateAsa(int id, int temperature, int cloud, int wind) {
        entityManager.getTransaction().begin();
        CachePlaceParametersModel updateAsa = entityManager.find(CachePlaceParametersModel.class, id);

        updateAsa.setTemperature(temperature);
        updateAsa.setCloud(cloud);
        updateAsa.setWind(wind);
    }

    // Varberg day0 = id[19] , day5 = id[24]
    public void updateVarberg(int id, int temperature, int cloud, int wind) {
        entityManager.getTransaction().begin();
        CachePlaceParametersModel updateVarberg = entityManager.find(CachePlaceParametersModel.class, id);

        updateVarberg.setTemperature(temperature);
        updateVarberg.setCloud(cloud);
        updateVarberg.setWind(wind);
    }

    // Falkenberg day0 = id[25] , day5 = id[30]
    public void updateFalkenberg(int id, int temperature, int cloud, int wind) {
        entityManager.getTransaction().begin();
        CachePlaceParametersModel updateFalkenberg = entityManager.find(CachePlaceParametersModel.class, id);

        updateFalkenberg.setTemperature(temperature);
        updateFalkenberg.setCloud(cloud);
        updateFalkenberg.setWind(wind);
    }
}
