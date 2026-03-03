package org.esocialsystems.esocialsystems.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.esocialsystems.esocialsystems.Model.Assure;

import java.util.List;

public class AssureDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eSocialPU");

    public void ajouter(Assure assure) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(assure);
        em.getTransaction().commit();
        em.close();
    }

    public List<Assure> trouverParEmployeur(Long employeurId) {
        EntityManager em = emf.createEntityManager();
        List<Assure> list = em.createQuery("SELECT a FROM Assure a WHERE a.employeur.id = :empId", Assure.class)
                .setParameter("empId", employeurId)
                .getResultList();
        em.close();
        return list;
    }
}
