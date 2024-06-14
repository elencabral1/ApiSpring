CREATE TABLE hotel (
    hotelId VARCHAR(255) NOT NULL PRIMARY KEY,
    echoToken VARCHAR(100),
    timestamp VARCHAR(255),
    sourceId VARCHAR(255),
    rateId VARCHAR(255)
);

CREATE TABLE ratePrice (
    ratePriceId INT AUTO_INCREMENT PRIMARY KEY,
    hotel_id VARCHAR(255),
    roomTypeId VARCHAR(255),
    FOREIGN KEY (hotel_id) REFERENCES hotel(hotelId)
);

CREATE TABLE price (
    priceId INT AUTO_INCREMENT PRIMARY KEY,
    `from` DATE,
    `to` DATE,
    ratePriceId INT,
    FOREIGN KEY (ratePriceId) REFERENCES ratePrice(priceId)
);

CREATE TABLE pax (
    paxId INT AUTO_INCREMENT PRIMARY KEY,
    capacity VARCHAR(10),
    price DECIMAL(10, 2),
    priceId INT,
    FOREIGN KEY (priceId) REFERENCES price(paxId)
);
