package se.theflow.vaderaktivitet.models;

import javax.persistence.*;

@Entity
@Table(name = "plats")
public class Plats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer platsId;

    private String platsNamn;

    private float platsLongitude;

    private float platsLatitude;



    /* Getter och Setters //dsve =P */

}