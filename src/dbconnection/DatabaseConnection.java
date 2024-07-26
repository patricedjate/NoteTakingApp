package dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {

	public DatabaseConnection() {
		// TODO Auto-generated constructor stub
	}
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/NotesDB", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
