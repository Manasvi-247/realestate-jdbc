package dao;

import model.Property;
import util.DBUtil;

import java.sql.*;
import java.time.LocalDate;

public class PropertyDAO {
    public void addProperty(Property property) {
        String insertProperty = "INSERT INTO Property (title, description, address, neighborhood, region, propertyType, listingDate, status) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        String linkAgent = "INSERT INTO propertyAgent (propertyId, agentId) VALUES (?, ?)";
        String insertPrice = "INSERT INTO propertyPriceHistory (propertyId, price, priceType) VALUES (?, ?, 'listed')";

        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);

            // 1. Insert into Property
            try (PreparedStatement stmt = conn.prepareStatement(insertProperty, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, property.getTitle());
                stmt.setString(2, property.getDescription());
                stmt.setString(3, property.getAddress());
                stmt.setString(4, property.getNeighborhood());
                stmt.setString(5, property.getRegion());
                stmt.setString(6, property.getPropertyType());
                stmt.setDate(7, Date.valueOf(property.getListingDate()));
                stmt.setString(8, property.getStatus());

                stmt.executeUpdate();

                // Get generated property ID
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int propertyId = rs.getInt(1);

                    // 2. Link to agent
                    try (PreparedStatement agentStmt = conn.prepareStatement(linkAgent)) {
                        agentStmt.setInt(1, propertyId);
                        agentStmt.setInt(2, property.getAgentId());
                        agentStmt.executeUpdate();
                    }


                    // 3. Insert initial price
                    try (PreparedStatement priceStmt = conn.prepareStatement(insertPrice)) {
                        priceStmt.setInt(1, propertyId);
                        priceStmt.setLong(2, property.getListedPrice());
                        priceStmt.executeUpdate();
                    }


                    conn.commit();
                    System.out.println("Property added with ID: " + propertyId);
                } else {
                    conn.rollback();
                    System.err.println("Failed to retrieve property ID");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error inserting property: " + e.getMessage());
        }
    }
}