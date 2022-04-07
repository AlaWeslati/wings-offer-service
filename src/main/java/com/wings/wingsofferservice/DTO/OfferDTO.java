package com.wings.wingsofferservice.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Data
public class OfferDTO {

    private String departGov;
    private String departAdr;
    private String arriGov;
    private String arriAdr;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date_delivery;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date Date_deadline;
    private double price;
    private String comment;
    private long userId;
}
