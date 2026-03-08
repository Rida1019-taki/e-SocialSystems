package org.esocialsystems.esocialsystems.Services;

import jakarta.persistence.EntityManager;
import org.esocialsystems.esocialsystems.DAO.AssureDAO;
import org.esocialsystems.esocialsystems.DAO.CotisationDAO;
import org.esocialsystems.esocialsystems.DAO.DeclarationDAO;
import org.esocialsystems.esocialsystems.Model.Assure;
import org.esocialsystems.esocialsystems.Model.Cotisation;
import org.esocialsystems.esocialsystems.Model.Declaration;


import java.math.BigDecimal;
import java.util.List;

public class CotisationServices {

    private static final BigDecimal TAUX_SALARIAL = new BigDecimal("0.04");
    private static final BigDecimal TAUX_PATRONAL = new BigDecimal("0.08");
    private static final BigDecimal PLAFOND = new BigDecimal("6000");

    private final CotisationDAO cotisationDAO;
    private final AssureDAO assureDAO;
    private final DeclarationDAO declarationDAO;

    public CotisationServices(EntityManager em) {
        this.cotisationDAO = new CotisationDAO(em);
        this.assureDAO = new AssureDAO(em);
        this.declarationDAO = new DeclarationDAO(em);
    }

    public void calculerCotisations(Long declarationId) {
        Declaration declaration = declarationDAO.findById(declarationId);
        if (declaration == null) return;

        List<Assure> assures = assureDAO.findByEmployeurId(declaration.getEmployeur().getId());

        for (Assure assure : assures) {
            BigDecimal salaire = assure.getSalaireMensuel();
            if (salaire.compareTo(PLAFOND) > 0) {
                salaire = PLAFOND;
            }

            BigDecimal cotSalariale = salaire.multiply(TAUX_SALARIAL);
            BigDecimal cotPatronale = salaire.multiply(TAUX_PATRONAL);

            Cotisation c = new Cotisation();
            c.setCotisationSalariale(cotSalariale);
            c.setCotisationPatronale(cotPatronale);
            c.setAssure(assure);
            c.setDeclaration(declaration);

            cotisationDAO.save(c);
        }
    }

    public BigDecimal totalParEmployeur(Long employeurId) {
        return cotisationDAO.totalByEmployeur(employeurId);
    }
}
