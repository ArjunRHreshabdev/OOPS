package com.tms.dataaccess;
import com.tms.models.User;
import java.sql.*;
public class UserDAO{
    public User getHashedPasswordAndRole(String username) throws SQLException{
        String sql="SELECT password,role FROM users WHERE username=?";
        try (Connection conn=DatabaseConnector.getInstance().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
                ps.setString(1, username);

                try(ResultSet rs=ps.executeQuery()){
                    if(rs.next()){
                        User user=new User();
                        user.setUsername(username);
                        user.setPassword(rs.getString("password"));
                        return user;
                    }
                }
            }
            return null;
    }
    public int addUser(User user, String hashedPassword) throws SQLException {
       
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, hashedPassword);
            ps.setString(3, user.getRole());
            
            int affectedRows = ps.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated user_id [cite: 89]
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
    }
}