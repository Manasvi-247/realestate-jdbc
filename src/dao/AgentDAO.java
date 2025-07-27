
package dao;

import model.Agent;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgentDAO {
    public void addAgent(Agent agent) {
        String sql = "INSERT INTO Agent (agencyId, name, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, agent.getAgencyId());
            stmt.setString(2, agent.getName());
            stmt.setString(3, agent.getEmail());
            stmt.setString(4, agent.getPhone());
            stmt.executeUpdate();

            System.out.println("Agent registered.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
