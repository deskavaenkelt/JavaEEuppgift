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
}
