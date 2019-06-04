package se.theflow.vaderaktivitet.models;

import javax.persistence.*;

@Entity
@Table(name = "cacheplaceparameters")
public class CachePlaceParameters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = aktivitetId)   - behövs ej pga samma namespace
    private Integer id;

    private Integer place;

    private Integer temperature;

    private Integer wind;

    private Integer cloud;



    /* Getters and Setters*/
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

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getWind() {
        return wind;
    }

    public void setWind(Integer wind) {
        this.wind = wind;
    }

    public Integer getCloud() {
        return cloud;
    }

    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }
}
