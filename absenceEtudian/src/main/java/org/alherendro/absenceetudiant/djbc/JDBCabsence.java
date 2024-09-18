package org.alherendro.absenceetudiant.djbc;

import lombok.Getter;
import lombok.Setter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Setter
@Getter
public class JDBCabsence {
    private Connection connection;

    String jdbcUrl = "jdbc:postgresql://localhost:5432/absence";
    String username = "postgres";
    String password = "alherendro";

    public JDBCabsence() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            if (connection != null) {
                System.out.println("votre connection PostgreSQL est etablie avec success  !");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println(" Connection expiré, ressayer plus tard !");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("bonjour!! tout vas bien ?");

        }
    }
}
