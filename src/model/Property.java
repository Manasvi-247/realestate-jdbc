package model;

import java.time.LocalDate;

public class Property {
    private int id;
    private String title;
    private String description;
    private String address;
    private String neighborhood;
    private String region;
    private LocalDate listingDate;
    private String status;
    private String propertyType;

    // FK relationships (for DAO use)
    private int agentId;
    private long listedPrice;

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getNeighborhood() { return neighborhood; }
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public LocalDate getListingDate() { return listingDate; }
    public void setListingDate(LocalDate listingDate) { this.listingDate = listingDate; }

    public String getPropertyType() { return propertyType; }
    public void setPropertyType(String propertyType) { this.propertyType = propertyType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getAgentId() { return agentId; }
    public void setAgentId(int agentId) { this.agentId = agentId; }

    public long getListedPrice() { return listedPrice; }
    public void setListedPrice(long listedPrice) { this.listedPrice = listedPrice; }
}