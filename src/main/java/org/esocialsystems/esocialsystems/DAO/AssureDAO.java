package org.esocialsystems.esocialsystems.DAO;

import jakarta.persistence.EntityManager;
import org.esocialsystems.esocialsystems.Model.Assure;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;


@ApplicationScoped
public class AssureDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Assure a) { em.persist(a); }

    public Assure findById(Long id) { return em.find(Assure.class, id); }

    public void update(Assure a) { em.merge(a); }

    public void delete(Long id) {
        Assure a = findById(id);
        if (a != null) em.remove(a);
    }

    public List<Assure> findAll() {
        return em.createQuery("SELECT a FROM Assure a", Assure.class)
                .getResultList();
    }

    public List<Assure> findByEmployeurId(Long employeurId) {
        return em.createQuery("SELECT a FROM Assure a WHERE a.employeur.id = :id", Assure.class)
                .setParameter("id", employeurId)
                .getResultList();
    }

    public List<Assure> findByDeclarationId(Long declarationId) {
        return em.createQuery(
                        "SELECT c.assure FROM Cotisation c WHERE c.declaration.id = :id", Assure.class)
                .setParameter("id", declarationId)
                .getResultList();
    }
}
