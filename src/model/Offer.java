package model;

import java.time.LocalDate;

public class Offer {
    private int id;
    private int agentId;
    private int buyerId;
    private int propertyId;
    private int offerAmount;
    private LocalDate offerDate;
    private String status;

    // Getters and setters
    public int getAgentId() { return agentId; }
    public void setAgentId(int agentId) { this.agentId = agentId; }

    public int getBuyerId() { return buyerId; }
    public void setBuyerId(int buyerId) { this.buyerId = buyerId; }

    public int getPropertyId() { return propertyId; }
    public void setPropertyId(int propertyId) { this.propertyId = propertyId; }

    public int getOfferAmount() { return offerAmount; }
    public void setOfferAmount(int offerAmount) { this.offerAmount = offerAmount; }

    public LocalDate getOfferDate() { return offerDate; }
    public void setOfferDate(LocalDate offerDate) { this.offerDate = offerDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}