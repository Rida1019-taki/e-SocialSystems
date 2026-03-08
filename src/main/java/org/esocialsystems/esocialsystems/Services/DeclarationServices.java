package org.esocialsystems.esocialsystems.Services;

import jakarta.persistence.EntityManager;
import org.esocialsystems.esocialsystems.DAO.AssureDAO;
import org.esocialsystems.esocialsystems.DAO.DeclarationDAO;
import org.esocialsystems.esocialsystems.DAO.EmployeurDAO;
import org.esocialsystems.esocialsystems.Model.Assure;
import org.esocialsystems.esocialsystems.Model.Declaration;
import org.esocialsystems.esocialsystems.Model.Employeur;

import java.time.LocalDate;
import java.util.List;

public class DeclarationServices {

    private final DeclarationDAO declarationDAO;
    private final AssureDAO assureDAO;
    private final EmployeurDAO employeurDAO;

    public DeclarationServices(EntityManager em) {
        this.declarationDAO = new DeclarationDAO(em);
        this.assureDAO = new AssureDAO(em);
        this.employeurDAO = new EmployeurDAO(em);
    }

    private void verifierUnicite(Long employeurId, int mois, int annee) {
        boolean existe = declarationDAO
                .existsByEmployeurMoisAnnee(employeurId, mois, annee);

        if (existe) {
            throw new RuntimeException("Déclaration déjà existante !");
        }
    }

    public Declaration creerDeclaration(Long employeurId,
                                        int mois,
                                        int annee,
                                        LocalDate dateDeclaration) {

        verifierUnicite(employeurId, mois, annee);

        Employeur employeur = employeurDAO.findById(employeurId);
        if (employeur == null) {
            throw new RuntimeException("Employeur non trouvé !");
        }

        Declaration declaration = new Declaration();
        declaration.setMois(mois);
        declaration.setAnnee(annee);
        declaration.setDateDeclaration(dateDeclaration);
        declaration.setEmployeur(employeur);

        declarationDAO.save(declaration);

        return declaration;
    }

    public List<Declaration> listerDeclarations() {
        return declarationDAO.findAll();
    }
}
