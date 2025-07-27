# 🏡 RealEstate JDBC Portal

A Java JDBC-based real estate listing and inquiry tracking system that allows agents to list properties and buyers to submit inquiries. The system manages full property lifecycle, from listing to offer and sale, with real-time status updates and insightful metrics.

---

## 📈 Business Context & Goal

A property portal where:

- Agents manage property listings
- Buyers register and inquire about properties
- Property data, pricing, offers, and communication are tracked through a MySQL database

The goal is to provide a complete backend prototype using **Java + JDBC + MySQL** with modular DAO classes for clean database interactions.

---

## ✅ Business Requirements

- 🧑‍💼 **Agent Registration**  
  Agents register with contact info and agency affiliations.

- 🏠 **Property Listing**  
  Agents list properties with:
  - Title, description
  - Address, neighborhood, region
  - Listing date and current status

- 📌 **Property Status Tracking**  
  Each property has a `status`:  
  `available` | `under_offer` | `sold`

- 🧩 **Property Features**  
  Properties may have multiple features:
  - e.g., pool, garden, garage, security system

- 🧍‍♂️ **Buyer Registration**  
  Buyers register with name, email, and phone.

- 📨 **Inquiries**  
  - Buyers submit inquiries for listed properties  
  - Each inquiry tracks message, date, and `status`:  
    `new` | `responded` | `closed`

- 🔍 **Full-text Search**  
  Supported on `property.description` using MySQL’s FULLTEXT indexing.

- ⏱ **Inquiry Metrics**  
  Response time tracking for each agent on inquiries.

---

## 🔄 JDBC-Based Architecture

- Cleanly modularized using **DAO pattern** (`AgencyDAO`, `AgentDAO`, `PropertyDAO`, etc.)
- Reusable **DBUtil** class to manage MySQL connection
- Transaction control using `conn.setAutoCommit(false)` where needed
- Uses **PreparedStatements** to prevent SQL injection

---

## 📊 Frequent Queries Implemented

| Query Type                            | Description |
|---------------------------------------|-------------|
| 🏘 Active Listings                    | Group by `neighborhood` and `propertyType` |
| 🏅 Agent Performance                  | Count of `sold` properties per agent |
| 🕐 Avg. Time on Market                | `DATEDIFF(soldDate, listingDate)` |
| 📉 Price Trend                        | Price history of properties by region |
| 📬 Inquiries Last Month               | Count grouped by property |
| ⏳ Pending Offers                     | Offers with `status = 'pending'` |

---

## 🗃️ Schema Overview

> See `schema.sql` for complete SQL table definitions.

Tables:
- `Agency`, `Agent`, `Buyer`, `Property`, `Feature`
- `propertyAgent`, `propertyFeature`, `propertyPriceHistory`
- `Inquiry`, `Offer`

---

## 🚀 How to Run

### 1. Prerequisites

- Java 11+ and IntelliJ or VS Code
- MySQL 8+
- Download MySQL JDBC Connector (`mysql-connector-j-8.x.x.jar`)

### 2. Setup

```bash
git clone https://github.com/Manasvi-247/realestate-jdbc.git
cd realestate-jdbc
