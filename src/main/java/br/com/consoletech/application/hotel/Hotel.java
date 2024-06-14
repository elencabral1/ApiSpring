package br.com.consoletech.application.hotel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "hotel")
@Entity
@Getter
@AllArgsConstructor
public class Hotel {

    @Column(name = "echoToken")
    private String echoToken;
    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "sourceId")
    private String sourceId;
    @Id
    @Column(name = "hotelId", nullable = false)
    private String hotelId;
    @Column(name = "rateId")
    private String rateId;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<RatePrice> ratePrices;

    public Hotel() {}

    public Hotel(String hotelId){
        this.hotelId = hotelId;
    }

    public Hotel(HotelDto hotelDto) {
        this.echoToken = hotelDto.echoToken();
        this.timestamp = hotelDto.timestamp();
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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
        this.timestamp = hotel.timestamp;
        this.sourceId = hotel.sourceId;
        this.hotelId = hotel.hotelId;
        this.rateId = hotel.rateId;
        this.ratePrices = ratePrices;
    }
}


