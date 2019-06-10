package se.theflow.vaderaktivitet.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActivityWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = aktivitetId)   - behövs ej pga samma namespace
    private Integer id;

    private Integer aId;

    private Integer vId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }
}