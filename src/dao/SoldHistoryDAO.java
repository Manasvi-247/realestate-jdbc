package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SoldHistoryDAO {
    public void markPropertyAsSold(int propertyId, long soldPrice, LocalDateTime soldAt) {
        String sql = "INSERT INTO propertyPriceHistory (propertyId, price, changedAt, priceType) VALUES (?, ?, ?, 'sold')";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, propertyId);
            stmt.setLong(2, soldPrice);
            stmt.setTimestamp(3, Timestamp.valueOf(soldAt));
            stmt.executeUpdate();
            System.out.println("Property marked as sold.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}