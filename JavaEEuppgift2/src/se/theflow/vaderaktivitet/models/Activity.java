package se.theflow.vaderaktivitet.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "activity")
public class Activity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = aktivitetId)   - behövs ej pga samma namespace
    private Integer id;

    //@Column(name = aktivitetNamn) - behövs ej pga samma namespace
    private String name;



    /* Getter och Setters //AlexO */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
