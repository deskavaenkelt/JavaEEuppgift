package se.theflow.vaderaktivitet.repository;
        import se.theflow.vaderaktivitet.models.Place;
        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import javax.persistence.Query;
        import java.util.List;

public class WeatherActivityRepository {
    @PersistenceContext(unitName = "VaderAktivitetPU")
    private EntityManager em;

    public List<Place> getAllPlaces() {
        /* Get all places Query AlexO */
        Query query = em.createQuery("SELECT c FROM Place c");
        return query.getResultList();
    }

    public List<Place> getFishingPoints() {
        /* Get all places Query AlexO */
        Query query = em.createQuery("SELECT c FROM CacheScores c order by fishing");
        return query.getResultList();
    }
    public List<Place> getOutdoorSeatingPoints() {
        /* Get all places Query AlexO */
        Query query = em.createQuery("SELECT c FROM CacheScores c order by outdoorSeating");
        return query.getResultList();
    }
    public List<Place> getSunBathingPoints() {
        /* Get all places Query AlexO */
        Query query = em.createQuery("SELECT c FROM CacheScores c order by sunBathing");
        return query.getResultList();
    }

    public List<Place> getVolleyBallPoints() {
        /* Get all places Query AlexO */
        Query query = em.createQuery("SELECT c FROM CacheScores c order by volleyBall");
        return query.getResultList();
    }
    public List<Place> getWindSurfingPoints() {
        /* Get all places Query AlexO */
        Query query = em.createQuery("SELECT c FROM CacheScores c order by windSurfing");
        return query.getResultList();
    }

}
