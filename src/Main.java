
import dao.*;
import model.*;
import util.DBUtil;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
//public class Main {
//    public static void main(String[] args) {
//        try (Connection conn = DBUtil.getConnection()) {
//            System.out.println(" Connected to database!");
//        } catch (Exception e) {
//            System.out.println(" Connection failed!");
//            e.printStackTrace();
//        }
//    }
//}

//This is purely for testing purpose.
public class Main {
    public static void main(String[] args) {

//        Agency agency = new Agency();
//        agency.setName("Urban Nest Realtors");
//        agency.setAddress("Swaroop nagar, Kanpur");
//        agency.setPhone("9876543210");
//
//        AgencyDAO agencyDAO = new AgencyDAO();
//        agencyDAO.addAgency(agency);
//
//        Agent agent = new Agent();
//        agent.setAgencyId(2); // use the actual agency ID from above
//        agent.setName("Manasvi");
//        agent.setEmail("manasvi@example.com");
//        agent.setPhone("9208253400");
//
//        AgentDAO dao = new AgentDAO();
//        dao.addAgent(agent);
//        // Insert buyer
//        Buyer buyer = new Buyer();
//        buyer.setName("Akshat");
//        buyer.setEmail("akshat@example.com");
//        buyer.setPhone("1111111111");
//
//        BuyerDAO buyerDAO = new BuyerDAO();
//        buyerDAO.addBuyer(buyer);

//        Property property = new Property();
//        property.setTitle("Studio flat");
//        property.setDescription("spacious 2bhk studio.");
//        property.setAddress("Concord enclave");
//        property.setNeighborhood("Swaroop nagar");
//        property.setRegion("kanpur city");
//        property.setPropertyType("Studio");
//        property.setListingDate(LocalDate.now());
//        property.setStatus("available");
//        property.setAgentId(6);
//        property.setListedPrice(8500000L);
//
//        PropertyDAO propertyDAO = new PropertyDAO();
//        propertyDAO.addProperty(property);

//        Offer offer = new Offer();
//        offer.setAgentId(1);
//        offer.setBuyerId(4);
//        offer.setPropertyId(5);
//        offer.setOfferAmount(9800000);
//        offer.setOfferDate(LocalDate.now());
//        offer.setStatus("pending");
//        OfferDAO offerDAO = new OfferDAO();
//        offerDAO.addOffer(offer);

//        Offer offer = new Offer();
//        offer.setAgentId(6);
//        offer.setBuyerId(5);
//        offer.setPropertyId(4);
//        offer.setOfferAmount(9400000);
//        offer.setOfferDate(LocalDate.of(2025, 7, 25));
//        offer.setStatus("accepted");
//
//        OfferDAO offerDAO = new OfferDAO();
//        offerDAO.addOffer(offer);
//        int propertyId = offer.getPropertyId();
//        long soldPrice = offer.getOfferAmount();
//        LocalDateTime soldAt = LocalDateTime.of(2025, 7, 27, 10, 30);
//
//        SoldHistoryDAO soldHistoryDAO = new SoldHistoryDAO();
//        soldHistoryDAO.markPropertyAsSold(propertyId, soldPrice, soldAt);

//        Inquiry inquiry = new Inquiry();
//        inquiry.setCreatedAt(LocalDateTime.now().minusDays(3));
//        inquiry.setMessage("Is this property still available?");
//        inquiry.setStatus("new");  // Can be 'new', 'responded', or 'closed'
//        inquiry.setAgentId(6);
//        inquiry.setBuyerId(4);
//        inquiry.setPropertyId(4);
//        inquiry.setClosedAt(null);
//
//        InquiryDAO dao = new InquiryDAO();
//        dao.addInquiry(inquiry);
    }
}