package org.esocialsystems.esocialsystems.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employeurs")
public class Employeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String raisonSociale;
    private String secteurActivite;

    @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL)
    private List<Assure> assures;

    @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL)
    private List<Declaration> declarations;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getRaisonSociale() { return raisonSociale; }
    public void setRaisonSociale(String raisonSociale) { this.raisonSociale = raisonSociale; }

    public String getSecteurActivite() { return secteurActivite; }
    public void setSecteurActivite(String secteurActivite) { this.secteurActivite = secteurActivite; }

    public List<Assure> getAssures() { return assures; }
    public void setAssures(List<Assure> assures) { this.assures = assures; }

    public List<Declaration> getDeclarations() { return declarations; }
    public void setDeclarations(List<Declaration> declarations) { this.declarations = declarations; }
}