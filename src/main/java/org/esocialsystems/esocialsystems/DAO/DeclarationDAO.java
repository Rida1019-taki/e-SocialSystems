package org.esocialsystems.esocialsystems.DAO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.esocialsystems.esocialsystems.Model.Declaration;

import java.util.List;

@ApplicationScoped
public class DeclarationDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Declaration d) { em.persist(d); }

    public Declaration findById(Long id) { return em.find(Declaration.class, id); }

    public void update(Declaration d) { em.merge(d); }

    public void delete(Long id) {
        Declaration d = findById(id);
        if (d != null) em.remove(d);
    }

    public List<Declaration> findAll() {
        return em.createQuery("SELECT d FROM Declaration d", Declaration.class)
                .getResultList();
    }

    public boolean existsByEmployeurMoisAnnee(Long employeurId, int mois, int annee) {
        Long count = em.createQuery(
                        "SELECT COUNT(d) FROM Declaration d WHERE d.employeur.id = :id AND d.mois = :mois AND d.annee = :annee", Long.class)
                .setParameter("id", employeurId)
                .setParameter("mois", mois)
                .setParameter("annee", annee)
                .getSingleResult();
        return count > 0;
    }

    public int countMoisByAssure(Long assureId) {
        Long count = em.createQuery(
                        "SELECT COUNT(DISTINCT d) FROM Declaration d JOIN d.cotisations c WHERE c.assure.id = :id", Long.class)
                .setParameter("id", assureId)
                .getSingleResult();
        return count.intValue();
    }
}
