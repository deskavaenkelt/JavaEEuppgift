package se.theflow.vaderaktivitet.models;

import javax.persistence.*;

@Entity
@Table(name = "weatherOptimal")
public class WeatherOptimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private Integer activity;
    private float temperature;
    private float rainfall;
    private Integer wind;
    private Integer cloudy;

    /* Getter och Setters //AlexO */

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getRainfall() {
        return rainfall;
    }

    public void setRainfall(float rainfall) {
        this.rainfall = rainfall;
    }

    public Integer getWind() {
        return wind;
    }

    public void setWind(Integer wind) {
        this.wind = wind;
    }

    public Integer getCloudy() {
        return cloudy;
    }

    public void setCloudy(Integer cloudy) {
        this.cloudy = cloudy;
    }
}