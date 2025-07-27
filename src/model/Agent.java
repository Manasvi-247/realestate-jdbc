
package model;

public class Agent {
    private int id;
    private int agencyId;
    private String name;
    private String email;
    private String phone;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAgencyId() { return agencyId; }
    public void setAgencyId(int agencyId) { this.agencyId = agencyId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
