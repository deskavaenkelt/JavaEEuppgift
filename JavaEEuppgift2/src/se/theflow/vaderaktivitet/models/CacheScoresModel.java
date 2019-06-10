package se.theflow.vaderaktivitet.models;


import javax.persistence.*;

@Entity
@Table(name = "cachescores")
public class CacheScoresModel {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getFishing() {
        return fishing;
    }

    public void setFishing(Integer fishing) {
        this.fishing = fishing;
    }

    public Integer getOutdoorSeating() {
        return outdoorSeating;
    }

    public void setOutdoorSeating(Integer outdoorSeating) {
        this.outdoorSeating = outdoorSeating;
    }

    public Integer getSunBathing() {
        return sunBathing;
    }

    public void setSunBathing(Integer sunBathing) {
        this.sunBathing = sunBathing;
    }

    public Integer getVolleyBall() {
        return volleyBall;
    }

    public void setVolleyBall(Integer volleyBall) {
        this.volleyBall = volleyBall;
    }

    public Integer getWindSurfing() {
        return windSurfing;
    }

    public void setWindSurfing(Integer windSurfing) {
        this.windSurfing = windSurfing;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = aktivitetId)   - behövs ej pga samma namespace
    private Integer id;

    private Integer place;

    private Integer fishing;

    private Integer outdoorSeating;

    private Integer sunBathing;

    private Integer volleyBall;

    private Integer windSurfing;


}
