package org.esocialsystems.esocialsystems.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.esocialsystems.esocialsystems.DAO.AssureDAO;
import org.esocialsystems.esocialsystems.DAO.DeclarationDAO;
import org.esocialsystems.esocialsystems.Model.Assure;
import org.esocialsystems.esocialsystems.Model.Declaration;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
@Transactional
public class DeclarationServices {

    @Inject
    private DeclarationDAO declarationDAO;

    @Inject
    private AssureDAO assureDAO;

    private void verifierUnicite(Long employeurId, int mois, int annee) {

        boolean existe = declarationDAO
                .existsByEmployeurMoisAnnee(employeurId, mois, annee);

        if (existe) {
            throw new RuntimeException("Déclaration déjà existante !");
        }
    }

    // ➜ Créer déclaration
    public Declaration creerDeclaration(Long employeurId,
                                        int mois,
                                        int annee,
                                        LocalDate dateDeclaration) {

        verifierUnicite(employeurId, mois, annee);

        Declaration declaration = new Declaration();
        declaration.setMois(mois);
        declaration.setAnnee(annee);
        declaration.setDateDeclaration(dateDeclaration);

        declarationDAO.save(declaration);

        return declaration;
    }

    public void ajouterSalaires(Long declarationId) {

        Declaration declaration = declarationDAO.findById(declarationId);

        List<Assure> assures =
                assureDAO.findByEmployeurId(
                        declaration.getEmployeur().getId());

        for (Assure a : assures) {
            // ici on prépare cotisation automatique
        }
    }

    public List<Declaration> listerDeclarations() {
        return declarationDAO.findAll();
    }
}
