CREATE TYPE marque_enum AS ENUM (
    'KIA',
    'HYUNDAI',
    'DAEWOO'
    );

CREATE TYPE modele_enum AS ENUM (
    'GETZ',
    'PRIDE',
    'LACETTI'
    );

CREATE TABLE Modele_voiture (
                                id SERIAL PRIMARY KEY,
                                marque marque_enum NOT NULL,
                                modele modele_enum NOT NULL
);

CREATE TABLE Piece_auto (
                            id SERIAL PRIMARY KEY,
                            id_modele_voiture INT NOT NULL,
                            numero_serie VARCHAR(50) UNIQUE NOT NULL,
                            prix NUMERIC(10,2) NOT NULL,

                            CONSTRAINT fk_modele
                                FOREIGN KEY (id_modele_voiture)
                                    REFERENCES Modele_voiture(id)
                                    ON DELETE CASCADE
);

CREATE TABLE Vente (
                       id SERIAL PRIMARY KEY,
                       id_piece_auto INT NOT NULL,
                       quantite INT NOT NULL CHECK (quantite > 0),

                       CONSTRAINT fk_piece
                           FOREIGN KEY (id_piece_auto)
                               REFERENCES Piece_auto(id)
                               ON DELETE CASCADE
);