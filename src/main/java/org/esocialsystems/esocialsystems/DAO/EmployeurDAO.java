package org.esocialsystems.esocialsystems.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.esocialsystems.esocialsystems.Model.Employeur;

import java.util.List;

public class EmployeurDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eSocialPU");

    public void ajouter(Employeur employeur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employeur);
        em.getTransaction().commit();
        em.close();
    }

    public List<Employeur> listerTous() {
        EntityManager em = emf.createEntityManager();
        List<Employeur> list = em.createQuery("SELECT e FROM Employeur e", Employeur.class).getResultList();
        em.close();
        return list;
    }

    public Employeur trouverParId(Long id) {
        EntityManager em = emf.createEntityManager();
        Employeur e = em.find(Employeur.class, id);
        em.close();
        return e;
    }
}
