package dao;

import model.Agency;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgencyDAO {
    public void addAgency(Agency agency) {
        String sql = "INSERT INTO Agency (name, address, phone) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, agency.getName());
            stmt.setString(2, agency.getAddress());
            stmt.setString(3, agency.getPhone());

            int rows = stmt.executeUpdate();
            System.out.println("Agency inserted. Rows affected: " + rows);
        } catch (SQLException e) {
            System.err.println("Error inserting agency: " + e.getMessage());
        }
    }
}