package org.esocialsystems.esocialsystems.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cotisation {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Assure assure;
    private double cotisationSalariale;
    private double cotisationPatronale;
}
