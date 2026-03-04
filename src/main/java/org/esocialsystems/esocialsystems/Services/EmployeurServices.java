package org.esocialsystems.esocialsystems.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.esocialsystems.esocialsystems.DAO.EmployeurDAO;
import org.esocialsystems.esocialsystems.Model.Employeur;
import java.util.List;

@ApplicationScoped
@Transactional
public class EmployeurServices {

    @Inject
    private EmployeurDAO employeurDAO;

    public void ajouter(Employeur employeur) {


        employeurDAO.save(employeur);
    }

    public Employeur findById(Long id) {
        return employeurDAO.findById(id);
    }

    public List<Employeur> findAll() {
        return employeurDAO.findAll();
    }

    public void update(Employeur employeur) {
        employeurDAO.update(employeur);
    }

    public void delete(Long id) {
        employeurDAO.delete(id);
    }
}
