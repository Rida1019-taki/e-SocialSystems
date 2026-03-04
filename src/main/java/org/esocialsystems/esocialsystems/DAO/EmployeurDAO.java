package org.esocialsystems.esocialsystems.DAO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.esocialsystems.esocialsystems.Model.Employeur;

import java.util.List;

@ApplicationScoped
public class EmployeurDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Employeur e) {
        em.persist(e);
    }

    public Employeur findById(Long id) {
        return em.find(Employeur.class, id);
    }

    public List<Employeur> findAll() {
        return em.createQuery("SELECT e FROM Employeur e", Employeur.class)
                .getResultList();
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
