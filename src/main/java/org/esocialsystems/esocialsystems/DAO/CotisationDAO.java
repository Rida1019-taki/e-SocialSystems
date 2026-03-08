package org.esocialsystems.esocialsystems.DAO;

import jakarta.persistence.EntityManager;
import org.esocialsystems.esocialsystems.Model.Cotisation;

import java.math.BigDecimal;
import java.util.List;

public class CotisationDAO {

    private final EntityManager em;

    public CotisationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Cotisation c) { em.persist(c); }

    public Cotisation findById(Long id) { return em.find(Cotisation.class, id); }

    public void update(Cotisation c) { em.merge(c); }

    public void delete(Long id) {
        Cotisation c = findById(id);
        if (c != null) em.remove(c);
    }

    public List<Cotisation> findAll() {
        return em.createQuery("SELECT c FROM Cotisation c", Cotisation.class)
                .getResultList();
    }

    public List<Cotisation> findByDeclarationId(Long declarationId) {
        return em.createQuery(
                        "SELECT c FROM Cotisation c WHERE c.declaration.id = :id", Cotisation.class)
                .setParameter("id", declarationId)
                .getResultList();
    }

    public BigDecimal totalByAssure(Long assureId) {
        BigDecimal total = em.createQuery(
                        "SELECT SUM(c.cotisationSalariale + c.cotisationPatronale) FROM Cotisation c WHERE c.assure.id = :id", BigDecimal.class)
                .setParameter("id", assureId)
                .getSingleResult();
        return total != null ? total : BigDecimal.ZERO;
    }

    public BigDecimal totalByEmployeur(Long employeurId) {
        BigDecimal total = em.createQuery(
                        "SELECT SUM(c.cotisationSalariale + c.cotisationPatronale) FROM Cotisation c WHERE c.assure.employeur.id = :id", BigDecimal.class)
                .setParameter("id", employeurId)
                .getSingleResult();
        return total != null ? total : BigDecimal.ZERO;
    }
}
