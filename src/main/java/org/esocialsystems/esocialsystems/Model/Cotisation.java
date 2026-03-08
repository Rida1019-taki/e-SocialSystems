package org.esocialsystems.esocialsystems.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cotisation")
public class Cotisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal cotisationSalariale;

    private BigDecimal cotisationPatronale;

    @ManyToOne
    @JoinColumn(name = "assure_id")
    private Assure assure;

    @ManyToOne
    @JoinColumn(name = "declaration_id")
    private Declaration declaration;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getCotisationSalariale() { return cotisationSalariale; }
    public void setCotisationSalariale(BigDecimal cotisationSalariale) { this.cotisationSalariale = cotisationSalariale; }

    public BigDecimal getCotisationPatronale() { return cotisationPatronale; }
    public void setCotisationPatronale(BigDecimal cotisationPatronale) { this.cotisationPatronale = cotisationPatronale; }

    public Assure getAssure() { return assure; }
    public void setAssure(Assure assure) { this.assure = assure; }

    public Declaration getDeclaration() { return declaration; }
    public void setDeclaration(Declaration declaration) { this.declaration = declaration; }
}
