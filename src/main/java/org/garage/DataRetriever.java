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
}
