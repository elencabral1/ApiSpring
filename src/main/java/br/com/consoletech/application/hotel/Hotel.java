package br.com.consoletech.application.hotel;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Table(name= "hotel")
@Entity
@Getter
@AllArgsConstructor
public class Hotel {

    @Column(name = "echoToken")
    private String echoToken;
    @Column(name = "receivableDate")
    private String receivableDate;
    @Column(name = "messageId", unique = true, nullable = false)
    private String messageId;
    @Column(name = "sourceId")
    private String sourceId;
    @Id
    @Column(name = "hotelId", nullable = false)
    private String hotelId;
    @Column(name = "rateId")
    private String rateId;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<RatePrice> ratePrices;

    public Hotel() {
        this.messageId = UUID.randomUUID().toString();
    }

    public Hotel(String hotelId){
        this.hotelId = hotelId;
        this.messageId = UUID.randomUUID().toString();
    }

    public Hotel(HotelDto hotelDto) {
        this.echoToken = hotelDto.echoToken();
        this.receivableDate = hotelDto.timestamp();
        this.messageId = UUID.randomUUID().toString() ;
        this.sourceId = hotelDto.sourceId();
        this.hotelId = hotelDto.hotelId();
        this.rateId = hotelDto.rateId();
        this.ratePrices = hotelDto.ratePrices().stream()
                .map(ratePriceDto -> new RatePrice(ratePriceDto))
                .collect(Collectors.toSet());
    }

    public String getEchoToken() {
        return echoToken;
    }

    public void setEchoToken(String echoToken) {
        this.echoToken = echoToken;
    }

    public String getReceivableDate() {
        return receivableDate;
    }

    public void setReceivableDate(String receivableDate) {
        this.receivableDate = receivableDate;
    }

    public String getMessageId() { return messageId;
    }

    public void setMessageId(String messageId) { this.messageId = messageId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public Set<RatePrice> getRatePrices() {
        return ratePrices;
    }

    public void setRatePrices(Set<RatePrice> ratePrices) {
        this.ratePrices = ratePrices;
    }

    public Hotel(Hotel hotel, Set<RatePrice> ratePrices) {
        this.echoToken = hotel.echoToken;
        this.receivableDate = hotel.receivableDate;
        this.messageId = hotel.messageId;
        this.sourceId = hotel.sourceId;
        this.hotelId = hotel.hotelId;
        this.rateId = hotel.rateId;
        this.ratePrices = ratePrices;
    }
}


