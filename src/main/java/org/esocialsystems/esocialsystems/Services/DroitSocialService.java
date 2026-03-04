package org.esocialsystems.esocialsystems.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.esocialsystems.esocialsystems.DAO.CotisationDAO;
import org.esocialsystems.esocialsystems.DAO.DeclarationDAO;

import java.math.BigDecimal;


@ApplicationScoped
public class DroitSocialService {

    @Inject
    private CotisationDAO cotisationDAO;

    @Inject
    private DeclarationDAO declarationDAO;

    public int nombreMoisDeclares(Long assureId) {
        return declarationDAO.countMoisByAssure(assureId);
    }

    public BigDecimal totalCotisations(Long assureId) {
        return cotisationDAO.totalByAssure(assureId);
    }
}
