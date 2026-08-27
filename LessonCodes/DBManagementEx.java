import java.sql.*;

public class DBManagementEx {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/SQLServer";
        String password = "Ankan@8804";
        String username = "postgres";
        try(Connection connection  = DriverManager.getConnection(url,username,password)){
            System.out.println("Connected to the database !");
        }

    }
}
