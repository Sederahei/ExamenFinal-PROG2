package org.alherendro.absenceetudiant.djbc;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
                System.out.println("Connected to the PostgreSQL database successfully!, felicitation!!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println(" Connection failure, sorry less baina !");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("hello world :-)");
        }
    }
}
