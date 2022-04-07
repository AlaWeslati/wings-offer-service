package com.wings.wingsofferservice.controller;

import com.wings.wingsofferservice.DTO.DemandDTO;
import com.wings.wingsofferservice.DTO.OfferDTO;
import com.wings.wingsofferservice.Models.Demand;
import com.wings.wingsofferservice.Models.Offer;
import com.wings.wingsofferservice.Service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OfferController {

    @Autowired
    OfferService offerService;

    @GetMapping("/GetAllOffer")
    public List<Offer> GetAllOffer(){
        return offerService.GetAllOffer();
    }

    @GetMapping("/GetOfferById/{id}")
    public List<Offer> GetOfferById(@PathVariable("id") long id){
        return offerService.GetOfferById(id);
    }

    @GetMapping("/GetOfferByUSerId/{id}")
    public List<Offer> GetOfferByUSerId(@PathVariable("id") long id){
        return offerService.GetOfferByUserId(id);
    }


    @PostMapping("/AddOffer")
    public ResponseEntity<?> AddOffer(OfferDTO offerDTO){
        try {
                offerService.AddOffer(offerDTO);
            return new ResponseEntity<>("Offer enregistrée avec succès", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/UpdateOfferById/{id}")
    public Offer UpdateOffer(@PathVariable("id") long id, @RequestBody OfferDTO offerDTO) {
        try{
            return offerService.UpdateOffer(id,offerDTO);
        }catch (Exception e) {
            return null;
        }
    }


    @DeleteMapping("/DeleteOfferById/{id}")
    public ResponseEntity<HttpStatus> deleteOfferById(@PathVariable("id") long id) {
        try {
            offerService.DeleteOfferById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/DeleteAllOffer")
    public ResponseEntity<HttpStatus> deleteAllOffer() {
        try {
            offerService.DeleteAllOffer();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
