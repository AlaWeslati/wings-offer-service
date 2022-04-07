package com.wings.wingsofferservice.repository;

import com.wings.wingsofferservice.Models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByPrice(double price);
    List<Offer> findByUserId(long id);
    List<Offer> findById(long id);
    Optional<Offer> findOffersById(long id);
}
