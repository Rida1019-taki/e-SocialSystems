package org.esocialsystems.esocialsystems.Services;

import jakarta.persistence.EntityManager;
import org.esocialsystems.esocialsystems.DAO.EmployeurDAO;
import org.esocialsystems.esocialsystems.Model.Employeur;
import java.util.List;

public class EmployeurServices {
    private final EmployeurDAO employeurDAO;

    public EmployeurServices(EntityManager em) {
        this.employeurDAO = new EmployeurDAO(em);
    }

    public void ajouter(Employeur employeur) { employeurDAO.save(employeur); }
    public Employeur findById(Long id) { return employeurDAO.findById(id); }
    public List<Employeur> findAll() { return employeurDAO.findAll(); }
    public void update(Employeur employeur) { employeurDAO.update(employeur); }
    public void delete(Long id) { employeurDAO.delete(id); }
}