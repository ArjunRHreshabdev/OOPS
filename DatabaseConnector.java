import java.sql.*;
public class DatabaseConnector {
    static final String db_url="jdbc:mysql://localhost:3306/OOP";
    static final String username="root";
    static final String password="Aswin_kb@2005";
    private static volatile DatabaseConnector instance;

    private Connection connection;
    private DatabaseConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(db_url, username, password);
            System.out.println("Database connection successfully established.");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }

    
    public static DatabaseConnector getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnector.class) {
                if (instance == null) {
                    instance = new DatabaseConnector();
                }
            }
        }
        return instance;
    }
      public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                System.out.println("Database connection was closed. Reconnecting...");
                this.connection = DriverManager.getConnection(db_url, username, password);
            }
        } catch (SQLException e) {
            System.err.println("Failed to check or re-establish database connection.");
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection.");
            e.printStackTrace();
        }
    }
}