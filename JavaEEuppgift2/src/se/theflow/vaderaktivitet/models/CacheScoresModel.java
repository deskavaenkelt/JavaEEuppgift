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

    public Float getFishing() {
        return fishing;
    }

    public void setFishing(Float fishing) {
        this.fishing = fishing;
    }

    public Float getOutdoorSeating() {
        return outdoorSeating;
    }

    public void setOutdoorSeating(Float outdoorSeating) {
        this.outdoorSeating = outdoorSeating;
    }

    public Float getSunBathing() {
        return sunBathing;
    }

    public void setSunBathing(Float sunBathing) {
        this.sunBathing = sunBathing;
    }

    public Float getVolleyBall() {
        return volleyBall;
    }

    public void setVolleyBall(Float volleyBall) {
        this.volleyBall = volleyBall;
    }

    public Float getWindSurfing() {
        return windSurfing;
    }

    public void setWindSurfing(Float windSurfing) {
        this.windSurfing = windSurfing;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = aktivitetId)   - behövs ej pga samma namespace
    private Integer id;

    private Integer place;

    private Float fishing;

    private Float outdoorSeating;

    private Float sunBathing;

    private Float volleyBall;

    private Float windSurfing;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int day;

}