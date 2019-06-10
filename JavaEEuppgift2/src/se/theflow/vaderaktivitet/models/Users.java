package se.theflow.vaderaktivitet.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = aktivitetId)   - behövs ej pga samma namespace
    private Integer id;

    @NotEmpty(message = "Username must be set")
    @Size(min = 4, message = "Must be att least 4 characters long")
    private String userName;

    private String userSalt;

    @NotEmpty(message = "Must set a user password")
    @Size(min = 8, message = "Must be att least 8 characters long")
    private String userPassword;

    public Users() {
    }

    public Users(@NotEmpty(message = "Username must be set") @Size(min = 4, message = "Must be att least 4 characters long") String userName, String userSalt, @NotEmpty(message = "Must set a user password") @Size(min = 8, message = "Must be att least 8 characters long") String userPassword) {
        this.userName = userName;
        this.userSalt = userSalt;
        this.userPassword = userPassword;
    }

    /*Getters and setters*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}

