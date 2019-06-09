package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.models.Users;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CreateNewUser {

    @Inject
    Users users;

    @PersistenceContext(unitName = "VaderAktivitetPU")
    private EntityManager entityManager;


}
