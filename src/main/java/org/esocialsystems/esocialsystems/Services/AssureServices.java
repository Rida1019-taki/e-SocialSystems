package org.esocialsystems.esocialsystems.Services;

import jakarta.persistence.EntityManager;
import org.esocialsystems.esocialsystems.DAO.AssureDAO;
import org.esocialsystems.esocialsystems.DAO.EmployeurDAO;
import org.esocialsystems.esocialsystems.Model.Assure;
import org.esocialsystems.esocialsystems.Model.Employeur;

import java.math.BigDecimal;
import java.util.List;

public class AssureServices {

    private final AssureDAO assureDAO;
    private final EmployeurDAO employeurDAO;

    public AssureServices(EntityManager em) {
        this.assureDAO = new AssureDAO(em);
        this.employeurDAO = new EmployeurDAO(em);
    }

    public void ajouterAssure(Long id, String nom,
                              BigDecimal salaireMensuel,
                              Long employeurId) {

        Assure assure = new Assure();
        if (id != null) assure.setId(id);
        assure.setNom(nom);
        assure.setSalaireMensuel(salaireMensuel);

        if (employeurId != null) {
            Employeur employeur = employeurDAO.findById(employeurId);
            assure.setEmployeur(employeur);
        }

        assureDAO.save(assure);
    }

    public void modifierSalaire(Long assureId, BigDecimal nouveauSalaire) {
        Assure assure = assureDAO.findById(assureId);
        if (assure != null) {
            assure.setSalaireMensuel(nouveauSalaire);
            assureDAO.update(assure);
        }
    }

    public List<Assure> listerAssures() {
        return assureDAO.findAll();
    }

    public List<Assure> listerParEmployeur(Long employeurId) {
        return assureDAO.findByEmployeurId(employeurId);
    }
}
