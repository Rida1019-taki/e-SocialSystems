package org.esocialsystems.esocialsystems.Services;

import jakarta.persistence.EntityManager;
import org.esocialsystems.esocialsystems.DAO.CotisationDAO;
import org.esocialsystems.esocialsystems.DAO.DeclarationDAO;

import java.math.BigDecimal;

public class DroitSocialService {

    private final CotisationDAO cotisationDAO;
    private final DeclarationDAO declarationDAO;

    public DroitSocialService(EntityManager em) {
        this.cotisationDAO = new CotisationDAO(em);
        this.declarationDAO = new DeclarationDAO(em);
    }

    public int nombreMoisDeclares(Long assureId) {
        return declarationDAO.countMoisByAssure(assureId);
    }

    public BigDecimal totalCotisations(Long assureId) {
        return cotisationDAO.totalByAssure(assureId);
    }
}
