package se.theflow.vaderaktivitet.repository;

import se.theflow.vaderaktivitet.models.CacheScoresModel;
import se.theflow.vaderaktivitet.models.WeatherOptimalModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class WeatherOptimalRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VaderAktivitetPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @PersistenceContext(unitName = "VaderAktivitetPU")
    EntityManager em;

    // activity[0] -> id[30]
    public float[] getOptimalValuesForActivity(int activityId) {
        System.out.println("Update score " + activityId);
        float[] temporary = new float[4];

        entityManager.getTransaction().begin();
        WeatherOptimalModel getOptimalWeather = em.find(WeatherOptimalModel.class, activityId);
        temporary[0] = getOptimalWeather.getTemperature();
        temporary[1] = getOptimalWeather.getCloudy();
        temporary[2] = getOptimalWeather.getWind();
        temporary[3] = getOptimalWeather.getRainfall();
        entityManager.getTransaction().commit();

        return temporary;
    }
}
