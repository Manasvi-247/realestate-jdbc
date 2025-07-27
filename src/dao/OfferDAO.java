package dao;

import model.Offer;
import util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OfferDAO {
    public void addOffer(Offer offer) {
        String sql = "INSERT INTO Offer (agentId, buyerId, propertyId, offerAmount, offerDate, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, offer.getAgentId());
            stmt.setInt(2, offer.getBuyerId());
            stmt.setInt(3, offer.getPropertyId());
            stmt.setInt(4, offer.getOfferAmount());
            stmt.setDate(5, Date.valueOf(offer.getOfferDate()));
            stmt.setString(6, offer.getStatus());

            int rows = stmt.executeUpdate();
            System.out.println("Offer inserted. Rows affected: " + rows);
        } catch (SQLException e) {
            System.err.println("Error inserting offer: " + e.getMessage());
        }
    }
}