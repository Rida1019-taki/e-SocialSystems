package org.esocialsystems.esocialsystems.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.esocialsystems.esocialsystems.DAO.AssureDAO;
import org.esocialsystems.esocialsystems.DAO.CotisationDAO;
import org.esocialsystems.esocialsystems.Model.Assure;
import org.esocialsystems.esocialsystems.Model.Cotisation;


import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
@Transactional
public class CotisationServices {

    private static final BigDecimal TAUX_SALARIAL = new BigDecimal("0.04");
    private static final BigDecimal TAUX_PATRONAL = new BigDecimal("0.08");
    private static final BigDecimal PLAFOND = new BigDecimal("6000");

    @Inject
    private CotisationDAO cotisationDAO;

    @Inject
    private AssureDAO assureDAO;

    public void calculerCotisations(Long declarationId) {

        List<Assure> assures =
                assureDAO.findByDeclarationId(declarationId);

        for (Assure assure : assures) {

            BigDecimal salaire = assure.getSalaireMensuel();

            if (salaire.compareTo(PLAFOND) > 0) {
                salaire = PLAFOND;
            }

            BigDecimal cotSalariale =
                    salaire.multiply(TAUX_SALARIAL);

            BigDecimal cotPatronale =
                    salaire.multiply(TAUX_PATRONAL);

            Cotisation c = new Cotisation();
            c.setCotisationSalariale(cotSalariale);
            c.setCotisationPatronale(cotPatronale);

            cotisationDAO.save(c);
        }
    }

    public BigDecimal totalParEmployeur(Long employeurId) {

        return cotisationDAO.totalByEmployeur(employeurId);
    }
}
