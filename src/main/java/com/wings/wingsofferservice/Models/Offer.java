package com.wings.wingsofferservice.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date date_delivery;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date Date_deadline;
	private double price;
	private String comment;
	@Enumerated(EnumType.STRING)
	private EtatOffer etatoffer;
	private long userId;
	private Long routeId;
	@Transient
	private Route route;

	public Offer() {
	}

	public Offer(Date date_delivery, Date date_deadline, double price, String comment, EtatOffer etatoffer, long userId, Long routeId) {
		this.date_delivery = date_delivery;
		this.Date_deadline = date_deadline;
		this.price = price;
		this.comment = comment;
		this.etatoffer = etatoffer;
		this.userId = userId;
		this.routeId = routeId;
	}


}
