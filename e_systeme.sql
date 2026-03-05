CREATE DATABASE e_social_systems;

USE e_social_systems;
CREATE TABLE employeur (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    raisonSociale VARCHAR(255) NOT NULL,
    secteurActivite VARCHAR(255)
);
CREATE TABLE assure (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    salaireMensuel DOUBLE NOT NULL,
    employeur_id BIGINT,
    CONSTRAINT fk_employeur FOREIGN KEY (employeur_id) REFERENCES employeur(id) ON DELETE CASCADE
);
CREATE TABLE declaration (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employeur_id BIGINT,
    mois INT NOT NULL,
    annee INT NOT NULL,
    dateDeclaration DATE,
    CONSTRAINT fk_declaration_employeur FOREIGN KEY (employeur_id) REFERENCES employeur(id) ON DELETE CASCADE,
    UNIQUE KEY unique_declaration (employeur_id, mois, annee)
);
CREATE TABLE cotisation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    assure_id BIGINT,
    declaration_id BIGINT,
    cotisationSalariale DOUBLE,
    cotisationPatronale DOUBLE,
    CONSTRAINT fk_cotisation_assure FOREIGN KEY (assure_id) REFERENCES assure(id) ON DELETE CASCADE,
    CONSTRAINT fk_cotisation_declaration FOREIGN KEY (declaration_id) REFERENCES declaration(id) ON DELETE CASCADE
);

INSERT INTO employeur (raisonSociale, secteurActivite) VALUES 
('ABC SARL', 'Informatique'),
('XYZ SA', 'BTP'),
('DEF Entreprise', 'Santé');

INSERT INTO assure (nom, salaireMensuel, employeur_id) VALUES
('Mohamed Ali', 5000, 1),
('Fatima Zahra', 4500, 1),
('Youssef Ben', 6000, 1);

INSERT INTO declaration (employeur_id, mois, annee, dateDeclaration) VALUES
(1, 1, 2026, '2026-01-05'),
(1, 2, 2026, '2026-02-05');

INSERT INTO cotisation (assure_id, declaration_id, cotisationSalariale, cotisationPatronale) VALUES
(1, 1, LEAST(5000,6000)*0.04, LEAST(5000,6000)*0.12),
(2, 1, LEAST(4500,6000)*0.04, LEAST(4500,6000)*0.12),
(3, 1, LEAST(6000,6000)*0.04, LEAST(6000,6000)*0.12);















