package com.gt.supertier;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

    @PersistenceContext
    private EntityManager em;


    @Produces
    public EntityManager create(){
        return em;
    }
}
