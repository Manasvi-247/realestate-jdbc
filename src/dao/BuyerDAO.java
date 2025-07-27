package dao;

import model.Buyer;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuyerDAO {
    public void addBuyer(Buyer buyer) {
        String sql = "INSERT INTO Buyer (name, email, phone) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, buyer.getName());
            stmt.setString(2, buyer.getEmail());
            stmt.setString(3, buyer.getPhone());

            int rowsInserted = stmt.executeUpdate();
            System.out.println("Buyer inserted! Rows affected: " + rowsInserted);

        } catch (SQLException e) {
            System.err.println("Error inserting buyer: " + e.getMessage());
        }
    }
}