package br.com.consoletech.application.hotel;

import jakarta.persistence.*;

@Entity
@Table(name = "pax")
public class Pax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paxId;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "ratePeriodId", nullable = false)
    private RatePeriod prices;


    public Pax(){}


    public Pax(PaxDto dto) {
        this.capacity = dto.capacity();
        this.price = dto.price();
    }

    public Integer getPaxId() {
        return paxId;
    }

    public void setPaxId(Integer paxId) {
        this.paxId = paxId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RatePeriod getPrices() {
        return prices;
    }

    public Pax(Pax pax, RatePeriod price){
        this.capacity = pax.capacity;
        this.price = pax.price;
        this.prices = price;
    }

    public void setPrices(RatePeriod prices) {
        this.prices = prices;
    }
}
