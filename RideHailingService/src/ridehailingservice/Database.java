/*

 */
package ridehailingservice;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    String url = "jdbc:sqlserver://localhost:1433;databaseName=RideHailing;integratedSecurity=true;encrypt=false";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public void addRider(RiderClass rider) throws SQLException {
        String sql = "INSERT INTO Rider (name, id, available) VALUES (?, ?, ?)";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rider.getName());
            pstmt.setString(2, rider.getId());
            pstmt.setString(3, rider.getAvailable());
            pstmt.executeUpdate();
        }
    }

    public String displayRider(RiderClass rider) throws SQLException {
        String sql = "SELECT * FROM Rider";
        StringBuilder result = new StringBuilder();

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            result.append(String.format("%-20s%-15s%-15sn", "name", "id", "available"));
            //result.append("--------------------------------------------------------------------------------------------------------\n");
            while (rs.next()) {
                String name = rs.getString("name");
                String id = rs.getString("id");
                String available = rs.getString("available");
                result.append(String.format("%-15s%-15s%-15s%n", name, id, available));
            }
        }

        return result.toString();
    }
}
