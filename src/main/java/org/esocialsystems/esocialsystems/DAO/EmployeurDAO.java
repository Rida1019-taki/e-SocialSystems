package org.esocialsystems.esocialsystems.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.esocialsystems.esocialsystems.Model.Employeur;
import java.util.List;

public class EmployeurDAO {

    private EntityManager em;

    public EmployeurDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eSocialPU");
        this.em = emf.createEntityManager();
    }

    public void save(Employeur e) {
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public List<Employeur> findAll() {
        return em.createQuery("SELECT e FROM Employeur e", Employeur.class)
                .getResultList();
    }

    public Employeur findById(Long id) {
        return em.find(Employeur.class, id);
    }

    public void update(Employeur e) {
        try {
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public void delete(Long id) {
        try {
            Employeur e = findById(id);
            if (e != null) {
                em.getTransaction().begin();
                em.remove(e);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}