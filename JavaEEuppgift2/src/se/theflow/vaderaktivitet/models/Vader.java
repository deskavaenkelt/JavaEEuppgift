package se.theflow.vaderaktivitet.models;

import javax.persistence.*;

@Entity
@Table(name = "vader")
public class Vader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vaderId;

    private float vaderTempMin;
    private float vaderTempMax;

    private float vaderNederbordMin;
    private float vaderNederbordMax;

    private Integer vaderMolnighetMin;
    private Integer vaderMolnighetMax;




    /* Getter och Setters //dsve =P */
    public Integer getVaderId() {
        return vaderId;
    }

    public void setVaderId(Integer vaderId) {
        this.vaderId = vaderId;
    }

    public float getVaderTempMin() {
        return vaderTempMin;
    }

    public void setVaderTempMin(float vaderTempMin) {
        this.vaderTempMin = vaderTempMin;
    }

    public float getVaderTempMax() {
        return vaderTempMax;
    }

    public void setVaderTempMax(float vaderTempMax) {
        this.vaderTempMax = vaderTempMax;
    }

    public float getVaderNederbordMin() {
        return vaderNederbordMin;
    }

    public void setVaderNederbordMin(float vaderNederbordMin) {
        this.vaderNederbordMin = vaderNederbordMin;
    }

    public float getVaderNederbordMax() {
        return vaderNederbordMax;
    }

    public void setVaderNederbordMax(float vaderNederbordMax) {
        this.vaderNederbordMax = vaderNederbordMax;
    }

    public Integer getVaderMolnighetMin() {
        return vaderMolnighetMin;
    }

    public void setVaderMolnighetMin(Integer vaderMolnighetMin) {
        this.vaderMolnighetMin = vaderMolnighetMin;
    }

    public Integer getVaderMolnighetMax() {
        return vaderMolnighetMax;
    }

    public void setVaderMolnighetMax(Integer vaderMolnighetMax) {
        this.vaderMolnighetMax = vaderMolnighetMax;
    }
}
