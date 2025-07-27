package dao;

import model.Inquiry;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InquiryDAO {
    public void addInquiry(Inquiry inquiry) {
        String sql = "INSERT INTO Inquiry (createdAt, message, status, agentId, buyerId, propertyId, closedAt) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, Timestamp.valueOf(inquiry.getCreatedAt()));
            stmt.setString(2, inquiry.getMessage());
            stmt.setString(3, inquiry.getStatus());
            stmt.setInt(4, inquiry.getAgentId());
            stmt.setInt(5, inquiry.getBuyerId());
            stmt.setInt(6, inquiry.getPropertyId());

            // `closedAt` may be null if not closed yet
            if (inquiry.getClosedAt() != null) {
                stmt.setTimestamp(7, Timestamp.valueOf(inquiry.getClosedAt()));
            } else {
                stmt.setNull(7, java.sql.Types.TIMESTAMP);
            }

            int rowsInserted = stmt.executeUpdate();
            System.out.println("Inquiry inserted! Rows affected: " + rowsInserted);

        } catch (SQLException e) {
            System.err.println("Error inserting inquiry: " + e.getMessage());
        }
    }
}