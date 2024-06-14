package br.com.consoletech.application.hotel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "ratePrice")
public class RatePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratePriceId;

    @Column(name = "roomTypeId")
    private String roomTypeId;

    @OneToMany(mappedBy = "ratePrice", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Price> priceList;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    public RatePrice(RatePriceDto dto) {
        this.roomTypeId = dto.roomTypeId();
        this.priceList = dto.prices().stream()
                .map(price -> new Price(price))
                .collect(Collectors.toSet());
    }

    public RatePrice(RatePrice ratePrice){
        this.roomTypeId = ratePrice.roomTypeId;
        this.priceList = ratePrice.priceList;
        this.hotel = null;
    }

    public RatePrice(){}

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getRatePriceId() {
        return ratePriceId;
    }

    public void setRatePriceId(Integer ratePriceId) {
        this.ratePriceId = ratePriceId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Set<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(Set<Price> priceList) {
        this.priceList = priceList;
    }

    public Hotel getHotel() {
        return hotel;
    }
}

