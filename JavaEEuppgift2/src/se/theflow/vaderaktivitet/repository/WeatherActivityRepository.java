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


    /*Get points for diffrent places AlexO*/
    public List<Place> getFishingPoints() {
        Query query = em.createQuery("SELECT c.fishing, p.name FROM CacheScoresModel c JOIN Place p ON c.place = p.id order by c.fishing desc");
        return query.getResultList();
    }
    public List<Place> getOutdoorSeatingPoints() {
        Query query = em.createQuery("SELECT c.outdoorSeating, p.name FROM CacheScoresModel c JOIN Place p ON c.place = p.id order by c.outdoorSeating desc");
        return query.getResultList();
    }
    public List<Place> getSunBathingPoints() {
        Query query = em.createQuery("SELECT c.sunBathing, p.name FROM CacheScoresModel c JOIN Place p ON c.place = p.id order by c.sunBathing desc");
        return query.getResultList();
    }

    public List<Place> getVolleyBallPoints() {
        Query query = em.createQuery("SELECT c.volleyBall, p.name FROM CacheScoresModel c JOIN Place p ON c.place = p.id order by c.volleyBall desc");
        return query.getResultList();
    }
    public List<Place> getWindSurfingPoints() {
        Query query = em.createQuery("SELECT c.windSurfing, p.name FROM CacheScoresModel c JOIN Place p ON c.place = p.id order by c.windSurfing desc");
        return query.getResultList();

    }
    
    public List<Place> getFishingPointsDay(int findday) {
        Query query = em.createQuery("SELECT c.fishing, p.name FROM CacheScoresModel c JOIN Place p ON c.place = p.id where c.day = '" + findday + "' order by c.fishing desc ");
        return query.getResultList();
    }
}