package org.esocialsystems.esocialsystems.Services;

import org.esocialsystems.esocialsystems.DAO.EmployeurDAO;
import org.esocialsystems.esocialsystems.Model.Employeur;
import java.util.List;

// Hayyedna @ApplicationScoped o @Transactional hit Tomcat ma-fihch CDI/JTA manager par défaut
public class EmployeurServices {

    // 1. Déclaration dial l-DAO
    private final EmployeurDAO employeurDAO;

    // 2. Constructeur bach n-initialiser l-DAO darouri
    public EmployeurServices() {
        this.employeurDAO = new EmployeurDAO();
    }

    public void ajouter(Employeur employeur) {
        // Daba employeurDAO ma-ghaybqach null
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