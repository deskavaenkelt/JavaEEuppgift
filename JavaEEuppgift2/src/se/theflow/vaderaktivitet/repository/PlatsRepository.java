package se.theflow.vaderaktivitet.repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PlatsRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer platsId;

    private String platsNamn;

    private float platsLongitude;

    private float platsLatitude;


    public Integer getPlatsId() {
        return platsId;
    }

    public void setPlatsId(Integer platsId) {
        this.platsId = platsId;
    }

    public String getPlatsNamn() {
        return platsNamn;
    }

    public void setPlatsNamn(String platsNamn) {
        this.platsNamn = platsNamn;
    }

    public float getPlatsLongitude() {
        return platsLongitude;
    }

    public void setPlatsLongitude(float platsLongitude) {
        this.platsLongitude = platsLongitude;
    }

    public float getPlatsLatitude() {
        return platsLatitude;
    }

    public void setPlatsLatitude(float platsLatitude) {
        this.platsLatitude = platsLatitude;
    }
}
