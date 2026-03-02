package org.esocialsystems.esocialsystems.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employeur {
    @Id
    @GeneratedValue
    private Long id;
    private String raisonSociale;
    private String secteurActivite;
    @OneToMany(mappedBy="employeur")
    private List<Assure> assures;
}
