package org.esocialsystems.esocialsystems.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.esocialsystems.esocialsystems.Model.Declaration;

public class CotisationDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eSocialPU");

    public boolean existeDeja(Long empId, int mois, int annee) {
        EntityManager em = emf.createEntityManager();
        Long count = em.createQuery("SELECT COUNT(d) FROM Declaration d WHERE d.employeur.id = :empId AND d.mois = :m AND d.annee = :a", Long.class)
                .setParameter("empId", empId)
                .setParameter("m", mois)
                .setParameter("a", annee)
                .getSingleResult();
        em.close();
        return count > 0;
    }

    public void enregistrer(Declaration d) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
    }
}
