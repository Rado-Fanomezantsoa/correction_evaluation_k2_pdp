--nombre de piece vendu par marque
SELECT mv.marque,
       SUM(v.quantite) AS nbrePiece
FROM Vente v
         JOIN Piece_auto pa
              ON v.id_piece_auto = pa.id
         JOIN Modele_voiture mv
              ON pa.id_modele_voiture = mv.id
GROUP BY mv.marque;


-- nombre de piece vendu par modele
SELECT
    SUM(CASE WHEN mv.modele = 'GETZ' THEN v.quantite ELSE 0 END) AS GETZ,
    SUM(CASE WHEN mv.modele = 'PRIDE' THEN v.quantite ELSE 0 END) AS PRIDE,
    SUM(CASE WHEN mv.modele = 'LACETTI' THEN v.quantite ELSE 0 END) AS LACETTI
FROM Vente v
         JOIN Piece_auto pa
              ON v.id_piece_auto = pa.id
         JOIN Modele_voiture mv
              ON pa.id_modele_voiture = mv.id;

--prix total des pices vendu par la marque KIA
SELECT SUM(pa.prix * v.quantite) AS prix_total_KIA
FROM Vente v
         JOIN Piece_auto pa
              ON v.id_piece_auto = pa.id
         JOIN Modele_voiture mv
              ON pa.id_modele_voiture = mv.id
WHERE mv.marque = 'KIA';