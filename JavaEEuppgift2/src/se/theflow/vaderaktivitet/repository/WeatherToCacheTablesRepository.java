package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.models.CachePlaceParametersModel;
import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

public class WeatherToCacheTablesRepository {

    // Inject Models
    @Inject
    CachePlaceParametersModel cachePlaceParametersModel;

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

    public CachePlaceParametersModel findPlace(int place) {
        return entityManager.find(CachePlaceParametersModel.class, place);
    }
}