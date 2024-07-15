package br.com.consoletech.application.hotel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "ratePeriod")
public class RatePeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratePeriodId;

    @Column(name = "`from`")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date from;

    @Column(name = "`to`")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date to;

    @ManyToOne
    @JoinColumn(name = "ratePriceId", nullable = false)
    @JsonIgnore
    private RatePrice ratePrice;

    @Getter
    @OneToMany(mappedBy = "prices", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pax> paxList;

    public RatePeriod(){}
    public RatePeriod(RatePeriodDto dto) {
        this.from = dto.from();
        this.to = dto.to();
        this.paxList = dto.pax().stream()
                .map(paxDto -> new Pax(paxDto))
                .collect(Collectors.toList());
    }

    public RatePeriod(RatePrice ratePrice, RatePeriod price, List<Pax> paxList){
        this.from = price.from;
        this.to = price.to;
        this.ratePrice = ratePrice;
        this.paxList = paxList;
    }


    public Integer getRatePeriodId() { return ratePeriodId;
    }

    public void setRatePeriodId(Integer ratePeriodId) { this.ratePeriodId = ratePeriodId;
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

