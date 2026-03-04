package org.esocialsystems.esocialsystems.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "assures")
public class Assure {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nom;

        private BigDecimal salaireMensuel;

        @ManyToOne
        @JoinColumn(name = "employeur_id")
        private Employeur employeur;

        @OneToMany(mappedBy = "assure", cascade = CascadeType.ALL)
        private java.util.List<Cotisation> cotisations;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; }

        public BigDecimal getSalaireMensuel() { return salaireMensuel; }
        public void setSalaireMensuel(BigDecimal salaireMensuel) { this.salaireMensuel = salaireMensuel; }

        public Employeur getEmployeur() { return employeur; }
        public void setEmployeur(Employeur employeur) { this.employeur = employeur; }

        public java.util.List<Cotisation> getCotisations() { return cotisations; }
        public void setCotisations(java.util.List<Cotisation> cotisations) { this.cotisations = cotisations; }

}