package se.theflow.vaderaktivitet.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aktivitet")
public class Aktivitet {


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
