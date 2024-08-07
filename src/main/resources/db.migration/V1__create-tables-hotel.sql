CREATE TABLE hotel (
    hotelId VARCHAR(255) NOT NULL,
    echoToken VARCHAR(100),
    receivableDate VARCHAR(255),
    messageId INT AUTO_INCREMENT PRIMARY KEY,
    sourceId VARCHAR(255),
    rateId VARCHAR(255),
    state INT DEFAULT 0
);

CREATE TABLE ratePrice (
    ratePriceId INT AUTO_INCREMENT PRIMARY KEY,
    messageId INT,
    roomTypeId VARCHAR(255),
    state INT DEFAULT 0,
    FOREIGN KEY (messageId) REFERENCES hotel(messageId)
);

CREATE TABLE ratePeriod (
    ratePeriodId INT AUTO_INCREMENT PRIMARY KEY,
    `from` DATE,
    `to` DATE,
    ratePriceId INT,
    state INT DEFAULT 0,
    FOREIGN KEY (ratePriceId) REFERENCES ratePrice(priceId)
);

CREATE TABLE pax (
    paxId INT AUTO_INCREMENT PRIMARY KEY,
    capacity VARCHAR(10),
    price DECIMAL(10, 2),
    ratePeriodId INT,
    state INT DEFAULT 0,
    FOREIGN KEY (ratePeriodId) REFERENCES ratePeriod(ratePeriodId)
);

CREATE TABLE process (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hotel_id VARCHAR(255) NOT NULL,
    status INT NOT NULL,
    detail VARCHAR(255)
);
