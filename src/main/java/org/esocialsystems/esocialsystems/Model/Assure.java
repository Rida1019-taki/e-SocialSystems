package org.esocialsystems.esocialsystems.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Assure {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private double salaireMensuel;
    @ManyToOne
    private Employeur employeur;
}