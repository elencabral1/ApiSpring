package br.com.consoletech.application.hotel;

import jakarta.persistence.*;

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
    private Set<RatePeriod> priceList;

    @ManyToOne
    @JoinColumn(name = "messageId", nullable = false)
    private Hotel hotel;

    public RatePrice(RatePriceDto dto) {
        this.roomTypeId = dto.roomTypeId();
        this.priceList = dto.prices().stream()
                .map(price -> new RatePeriod(price))
                .collect(Collectors.toSet());
    }


//    public ResponseEntity<?> getByRatePriceId(@PathVariable("ratePriceId") String ratePriceId) {
//        RatePrice ratePrice = hotelService.getByRatePriceId(ratePriceId);
//        if (ratePrice != null) {
//            return ResponseEntity.ok("Processed");
//        } else {
//            ErrorResponse errorResponse = new ErrorResponse(
//                    "RatePrice ID not found",
//                    "No ratePrice ID found with the provided messageId",
//                    "RatePrice ID NotFound"
//            );
//            return ResponseEntity.status(404).body(errorResponse);
//        }
//    }

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

    public Set<RatePeriod> getPriceList() {
        return priceList;
    }

    public void setPriceList(Set<RatePeriod> priceList) {
        this.priceList = priceList;
    }

    public Hotel getHotel() {
        return hotel;
    }
}

