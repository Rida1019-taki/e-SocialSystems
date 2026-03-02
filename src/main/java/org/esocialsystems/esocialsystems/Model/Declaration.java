package org.esocialsystems.esocialsystems.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Declaration {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Employeur employeur;
    private int mois;
    private int annee;
    private LocalDate dateDeclaration;
    @OneToMany(mappedBy="declaration", cascade=CascadeType.ALL)
    private List<Cotisation> cotisations;
}
