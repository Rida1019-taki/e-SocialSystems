package org.esocialsystems.esocialsystems.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "declarations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"employeur_id","mois","annee"}))
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mois;

    private int annee;

    private LocalDate dateDeclaration;

    @ManyToOne
    @JoinColumn(name = "employeur_id")
    private Employeur employeur;

    @OneToMany(mappedBy = "declaration", cascade = CascadeType.ALL)
    private List<Cotisation> cotisations;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getMois() { return mois; }
    public void setMois(int mois) { this.mois = mois; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }

    public LocalDate getDateDeclaration() { return dateDeclaration; }
    public void setDateDeclaration(LocalDate dateDeclaration) { this.dateDeclaration = dateDeclaration; }

    public Employeur getEmployeur() { return employeur; }
    public void setEmployeur(Employeur employeur) { this.employeur = employeur; }

    public List<Cotisation> getCotisations() { return cotisations; }
    public void setCotisations(List<Cotisation> cotisations) { this.cotisations = cotisations; }
}
