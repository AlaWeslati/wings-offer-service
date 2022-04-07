package com.wings.wingsofferservice.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private double weight;
    private double height;
    private double length;
    private String filename;
    private String filetype;
    private byte[] filedata;
    private String remark;
    private int VerificationCode;
    @Enumerated(EnumType.STRING)
    private EtatDemand etatdemand;
    private long userId;
    private  long routeId;

    @OneToOne
    private Offer offer;
    @Transient
    private Route route;
    /*
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date ;*/




}
