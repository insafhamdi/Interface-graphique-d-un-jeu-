package tp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnexion {
    private static final String url = "jdbc:mysql://localhost:3306/db_jeu?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = ""; 

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user,password);
    }




}
