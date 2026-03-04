package org.esocialsystems.esocialsystems.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.esocialsystems.esocialsystems.DAO.AssureDAO;
import org.esocialsystems.esocialsystems.Model.Assure;

import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
@Transactional
public class AssureServices {

    @Inject
    private AssureDAO assureDAO;

    // ➜ Ajouter un assuré
    public void ajouterAssure(Long id, String nom,
                              BigDecimal salaireMensuel,
                              Long employeurId) {

        Assure assure = new Assure();
        assure.setId(id);
        assure.setNom(nom);
        assure.setSalaireMensuel(salaireMensuel);

        assureDAO.save(assure);
    }

    public void modifierSalaire(Long assureId, BigDecimal nouveauSalaire) {

        Assure assure = assureDAO.findById(assureId);

        assure.setSalaireMensuel(nouveauSalaire);

        assureDAO.update(assure);
    }

    public List<Assure> listerAssures() {
        return assureDAO.findAll();
    }

    public List<Assure> listerParEmployeur(Long employeurId) {
        return assureDAO.findByEmployeurId(employeurId);
    }
}