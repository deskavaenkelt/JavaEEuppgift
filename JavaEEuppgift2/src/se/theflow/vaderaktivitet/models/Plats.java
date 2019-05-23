package se.theflow.vaderaktivitet.models;

import javax.persistence.*;

@Entity
@Table(name = "place")
public class Plats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private float longitude;

    private float latitude;



    /* Getter och Setters //dsve =P */

}
