
CREATE DATABASE IF NOT EXISTS realestate;
USE realestate;

-- 1. Agency
CREATE TABLE Agency (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) not null,
    address VARCHAR(200),
    phone VARCHAR(20)
);

-- 2. Agent
CREATE TABLE Agent (
    id INT AUTO_INCREMENT PRIMARY KEY,
    agencyId INT,
    name VARCHAR(100) not null,
    email VARCHAR(200)unique not null,
    phone VARCHAR(20) unique not null,
    FOREIGN KEY (agencyId) REFERENCES Agency(id)
);

-- 3. Buyer
CREATE TABLE Buyer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) not null,
    email VARCHAR(200) unique not null,
    phone VARCHAR(20) unique not null
);

-- 4. Feature
CREATE TABLE Feature (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) unique not null,
    category ENUM('interior', 'exterior', 'amenity', 'safety')
);

-- 5. Property
CREATE TABLE Property (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) not null,
    description TEXT,
    address VARCHAR(200) not null,
    neighborhood VARCHAR(100),
    region VARCHAR(100),
    propertyType varchar(100),
    listingDate DATETIME not null,
    status ENUM('available', 'under_offer', 'sold') not null,
    FULLTEXT(description)
);

-- 6. propertyFeature
CREATE TABLE propertyFeature (
    propertyId INT,
    featureId INT,
    PRIMARY KEY (propertyId, featureId),
    FOREIGN KEY (propertyId) REFERENCES Property(id),
    FOREIGN KEY (featureId) REFERENCES Feature(id)
);

-- 7. propertyAgent
CREATE TABLE propertyAgent (
    propertyId INT not null,
    agentId INT not null,
    PRIMARY KEY (propertyId, agentId),
    FOREIGN KEY (propertyId) REFERENCES Property(id),
    FOREIGN KEY (agentId) REFERENCES Agent(id)
);

-- 8. propertyPriceHistory
CREATE TABLE propertyPriceHistory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    propertyId INT,
    price BIGINT not null,
    changedAt DATETIME not null default current_timestamp,
    priceType ENUM('listed', 'reduced', 'sold') not null,
    FOREIGN KEY (propertyId) REFERENCES Property(id)
);

-- 9. Inquiry
CREATE TABLE Inquiry (
    id INT AUTO_INCREMENT PRIMARY KEY,
    createdAt DATETIME,
    message TEXT,
    status ENUM('new', 'responded', 'closed'),
    agentId INT,
    buyerId INT,
    propertyId INT,
    closedAt DATETIME,
    FOREIGN KEY (agentId) REFERENCES Agent(id),
    FOREIGN KEY (buyerId) REFERENCES Buyer(id),
    FOREIGN KEY (propertyId) REFERENCES Property(id)
);

-- 10. Offer
CREATE TABLE Offer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    agentId INT,
    buyerId INT,
    propertyId INT,
    offerAmount INT,
    offerDate DATETIME,
    status ENUM('pending', 'accepted', 'rejected') not null default 'pending',
    FOREIGN KEY (agentId) REFERENCES Agent(id),
    FOREIGN KEY (buyerId) REFERENCES Buyer(id),
    FOREIGN KEY (propertyId) REFERENCES Property(id)
);
