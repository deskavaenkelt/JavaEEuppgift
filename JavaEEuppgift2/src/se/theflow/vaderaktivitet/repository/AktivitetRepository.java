package se.theflow.vaderaktivitet.repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AktivitetRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = aktivitetId)   - behövs ej pga samma namespace
    private Integer aktivitetId;

    //@Column(name = aktivitetNamn) - behövs ej pga samma namespace
    private String aktivitetsNamn;



    /* Getter och Setters //dsve =P */
    public Integer getAktivitetId() {
        return aktivitetId;
    }

    public void setAktivitetId(Integer aktivitetId) {
        this.aktivitetId = aktivitetId;
    }

    public String getAktivitetsNamn() {
        return aktivitetsNamn;
    }

    public void setAktivitetsNamn(String aktivitetsNamn) {
        this.aktivitetsNamn = aktivitetsNamn;
    }
}
