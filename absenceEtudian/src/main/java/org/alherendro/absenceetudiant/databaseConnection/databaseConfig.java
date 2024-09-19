package org.alherendro.absenceetudiant.databaseConnection;

/*import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class databaseConfig {
    @Bean
    public static Connection getConnection() throws SQLException {
        String url = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");
        return DriverManager.getConnection(url,username,password);
    }
}*/



import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class databaseConfig {
    @Bean
    public static Connection getConnection() {
        String url = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println(" la connection avec la base de donnee est etablie avec success, felicitation!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Il y a des erreurs dans votre base de données,veuillez ressayer: " + e.getMessage());
            return null;
        }
    }
}

