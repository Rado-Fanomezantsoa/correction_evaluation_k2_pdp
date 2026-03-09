INSERT INTO Modele_voiture (marque, modele) VALUES
                                                ('KIA', 'PRIDE'),
                                                ('KIA', 'GETZ'),
                                                ('HYUNDAI', 'GETZ'),
                                                ('DAEWOO', 'LACETTI');

INSERT INTO Piece_auto (id_modele_voiture, numero_serie, prix) VALUES
                                                                   (1, 'KIA-P-001', 50000),
                                                                   (1, 'KIA-P-002', 75000),
                                                                   (2, 'KIA-G-001', 60000),
                                                                   (3, 'HYU-G-001', 45000),
                                                                   (4, 'DAE-L-001', 80000);
INSERT INTO Vente (id_piece_auto, quantite) VALUES
                                                (1, 2),
                                                (2, 1),
                                                (3, 3),
                                                (4, 4),
                                                (5, 2);