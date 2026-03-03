package org.esocialsystems.esocialsystems.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.esocialsystems.esocialsystems.Model.Cotisation;

public class DeclarationDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eSocialPU");

    public void enregistrer(Cotisation c) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }
}
