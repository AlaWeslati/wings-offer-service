package com.wings.wingsofferservice.Service;

import com.wings.wingsofferservice.DTO.OfferDTO;
import com.wings.wingsofferservice.Models.EtatOffer;
import com.wings.wingsofferservice.Models.Offer;
import com.wings.wingsofferservice.Models.Route;
import com.wings.wingsofferservice.feign.UserServiceFeign;
import com.wings.wingsofferservice.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    @Autowired
    OfferRepository offerRepository;

    private  final UserServiceFeign userServiceFeign;

    public OfferService(UserServiceFeign userServiceFeign) {
        this.userServiceFeign = userServiceFeign;
    }

    public List<Offer> GetAllOffer(){
        List<Offer> offerList=offerRepository.findAll();
        for(Offer offer:offerList){
            Optional<Route> route=userServiceFeign.getRoute(offer.getRouteId());
            offer.setRoute(route.get());
        }
        return offerList;
    }

    public List<Offer> GetOfferById(long id){
        List<Offer> offerList=offerRepository.findById(id);
        for(Offer offer:offerList){
            Optional<Route> route=userServiceFeign.getRoute(offer.getRouteId());
            offer.setRoute(route.get());
        }
        return offerList;
    }

    public List<Offer> GetOfferByUserId(long id){
        List<Offer> offerList=offerRepository.findByUserId(id);
        for(Offer offer:offerList){
            Optional<Route> route=userServiceFeign.getRoute(offer.getRouteId());
            offer.setRoute(route.get());
        }
       // offerList.stream().allMatch(f->f.setRoute( userServiceFeign.getRoute(f.getRoute().getId()));
        return offerList;
    }


    public Offer AddOffer(OfferDTO offerDTO){
        Route routeRequest = new Route(offerDTO.getDepartGov(),offerDTO.getDepartAdr(),offerDTO.getArriGov(),offerDTO.getArriAdr());
        Route routeResponse = userServiceFeign.newRoute(offerDTO.getUserId(),routeRequest);

        Offer offer = new Offer(offerDTO.getDate_delivery(),offerDTO.getDate_deadline(),offerDTO.getPrice(),offerDTO.getComment(), EtatOffer.pending,offerDTO.getUserId(),routeResponse.getId());
        return offerRepository.save(offer);
    }

    public Offer UpdateOffer(long id , OfferDTO offerDTO){
        Optional<Offer> offer = offerRepository.findOffersById(id);
        if (offer.isPresent()) {
            Route routeRequest = new Route(offerDTO.getDepartGov(), offerDTO.getDepartAdr(), offerDTO.getArriGov(), offerDTO.getArriAdr());
            Route routeResponse = userServiceFeign.UpdateRoute(offer.get().getRouteId(), routeRequest);
            Offer _offer = offer.get();
            _offer.setDate_delivery(offerDTO.getDate_delivery());
            _offer.setDate_deadline(offerDTO.getDate_deadline());
            _offer.setPrice(offerDTO.getPrice());
            _offer.setComment(offerDTO.getComment());
            return offerRepository.save(_offer);
        }else {
            return null;
        }
    }

    public void DeleteOfferById(long id) {
        Optional<Offer> offer=offerRepository.findOffersById(id);
        if(offer==null) throw new RuntimeException("Offer Not found");
        userServiceFeign.DeleteRoute(offer.get().getRouteId());
        offerRepository.deleteById(id);
    }

    public void DeleteAllOffer() {
        List<Offer> offerList=offerRepository.findAll();
        for(Offer offer:offerList){
            Optional<Route> route=userServiceFeign.getRoute(offer.getRouteId());
            if(route.isPresent())
                userServiceFeign.DeleteRoute(offer.getRouteId());
        }
        offerRepository.deleteAll();
    }
}
