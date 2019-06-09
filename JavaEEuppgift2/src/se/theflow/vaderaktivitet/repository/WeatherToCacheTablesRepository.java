package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.models.CachePlaceParametersModel;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

public class WeatherToCacheTablesRepository {

    // Inject Models
    @Inject
    CachePlaceParametersModel cachePlaceParametersModel;

    //@PersistenceContext(unitName = "VaderAktivitetPU")
    //private EntityManager entityManager;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VaderAktivitetPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public List<CachePlaceParametersModel> getAllPlaces() {
        /* Get all places Query AlexO */
        Query query = entityManager.createQuery("SELECT c FROM CachePlaceParametersModel c");
        return query.getResultList();
    }

    public List<CachePlaceParametersModel> findPlaceByPlaceId(int searchForId) {
        // return one place.object
        Query query = entityManager.createQuery("SELECT c FROM CachePlaceParametersModel c WHERE place = '" + searchForId + "'");
        return query.getResultList();
    }
    public List<CachePlaceParametersModel> findPlaceByPlaceIdAndUpdate(int searchForPlace, int searchForDay) {
        // return one place.object
        Query query = entityManager.createQuery("SELECT c FROM CachePlaceParametersModel c WHERE place = '" + searchForPlace + "' AND day = '" + searchForDay + "'");
        return query.getResultList();
    }

    public void setCachePlaceParameters(int place, int day, int updateTemperature, int updateWind, int updateCloud) {

        // String query = "UPDATE cachePlaceParametersModel SET temperature = ?, wind = ?, cloud = ?, WHERE place = ?, AND day = ?";


        //cachePlaceParametersModel.s
        Query query = entityManager.createQuery("UPDATE cachePlaceParameters\n" +
                "SET temperature = '" + updateTemperature + "',\n" +
                "    wind = '" + updateWind + "',\n" +
                "    cloud = '" + updateCloud + "',\n" +
                "WHERE place = '" + place + "',\n" +
                "  AND day = '" + day + "'");

        //int updateCount = entityManager.e
    }


    public CachePlaceParametersModel findPlace(int place) {
        return entityManager.find(CachePlaceParametersModel.class, place);
    }

}
