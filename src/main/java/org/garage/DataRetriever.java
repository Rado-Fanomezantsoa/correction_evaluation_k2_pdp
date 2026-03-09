package org.garage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    public List<VenteParMarque> findVenteParMarque() {

        List<VenteParMarque> list = new ArrayList<>();
        String sql = """
                SELECT mv.marque,
                                   SUM(v.quantite) AS nbrePiece
                            FROM Vente v
                            JOIN Piece_auto pa ON v.id_piece_auto = pa.id
                            JOIN Modele_voiture mv ON pa.id_modele_voiture = mv.id
                            GROUP BY mv.marque;
""";

        try (Connection connection =  new DbConnection().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery();
        ){



            while (rs.next()) {
                VenteParMarque vpm = new VenteParMarque();

                // setters (mapping)
                vpm.setMarque(rs.getString("marque"));
                vpm.setNbrePiece(rs.getInt("nbrePiece"));

                list.add(vpm);
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //b)
    public VenteParModele findVenteParModele() {
        String sql = """
                SELECT
                SUM(CASE WHEN mv.modele='GETZ' THEN v.quantite ELSE 0 END) AS GETZ,
                SUM(CASE WHEN mv.modele='PRIDE' THEN v.quantite ELSE 0 END) AS PRIDE,
                SUM(CASE WHEN mv.modele='LACETTI' THEN v.quantite ELSE 0 END) AS LACETTI
            FROM Vente v
            JOIN Piece_auto pa ON v.id_piece_auto = pa.id
            JOIN Modele_voiture mv ON pa.id_modele_voiture = mv.id
                """;
        try (Connection connection =new DbConnection().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        )
        {



            if (rs.next()) {
                VenteParModele vpm = new VenteParModele();

                // setters
                vpm.setGetz(rs.getInt("GETZ"));
                vpm.setPride(rs.getInt("PRIDE"));
                vpm.setLacetti(rs.getInt("LACETTI"));

                return vpm;
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TotalPrix findTotalPrixKia() {
        String sql = """
                SELECT SUM(pa.prix * v.quantite) AS total
            FROM Vente v
            JOIN Piece_auto pa ON v.id_piece_auto = pa.id
            JOIN Modele_voiture mv ON pa.id_modele_voiture = mv.id
            WHERE mv.marque = 'KIA';    
                """;

        try (Connection connection = new DbConnection().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        )
        {
            if (rs.next()) {
                TotalPrix tp = new TotalPrix();

                tp.setTotal(rs.getDouble("total"));

                return tp;
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
