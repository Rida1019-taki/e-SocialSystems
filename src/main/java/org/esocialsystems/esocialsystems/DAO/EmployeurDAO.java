package org.esocialsystems.esocialsystems.DAO;

import jakarta.persistence.EntityManager;
import org.esocialsystems.esocialsystems.Model.Employeur;
import java.util.List;

public class EmployeurDAO {
    private EntityManager em;

    public EmployeurDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Employeur e) {
        em.persist(e);
    }

    public List<Employeur> findAll() {
        return em.createQuery("SELECT e FROM Employeur e", Employeur.class).getResultList();
    }

    public Employeur findById(Long id) {
        return em.find(Employeur.class, id);
    }

    public void update(Employeur e) {
        em.merge(e);
    }

    public void delete(Long id) {
        Employeur e = findById(id);
        if (e != null) {
            em.remove(e);
        }
    }
}