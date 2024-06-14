package br.com.consoletech.application.hotel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceId;

    @Column(name = "`from`")
    private Date from;

    @Column(name = "`to`")
    private Date to;

    @ManyToOne
    @JoinColumn(name = "ratePriceId", nullable = false)
    @JsonIgnore
    private RatePrice ratePrice;

    @Getter
    @OneToMany(mappedBy = "prices", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pax> paxList;

    public Price(){}
    public Price(PriceDto dto) {
        this.from = dto.from();
        this.to = dto.to();
        this.paxList = dto.pax().stream()
                .map(paxDto -> new Pax(paxDto))
                .collect(Collectors.toList());
    }

    public Price(RatePrice ratePrice, Price price, List<Pax> paxList){
        this.from = price.from;
        this.to = price.to;
        this.ratePrice = ratePrice;
        this.paxList = paxList;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public RatePrice getRatePrice() {
        return ratePrice;
    }

    public List<Pax> getPaxList() {
        return paxList;
    }

    public void setPaxList(List<Pax> paxList) {
        this.paxList = paxList;
    }

    public void setRatePrice(RatePrice ratePrice) {
        this.ratePrice = ratePrice;
    }

}

