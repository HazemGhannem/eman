package com.example.bii.Controller;

import com.example.bii.Entity.Evenement;
import com.example.bii.Entity.Logistique;
import com.example.bii.Entity.Participant;
import com.example.bii.Service.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
public class cont {
    private Iservice service;

    @PostMapping("/addpathologie")
    public ResponseEntity<?> ShowAllUsers(@RequestBody Participant pa ){
        service.ajouterParticipant(pa);
        return new ResponseEntity<>( service.ajouterParticipant(pa), HttpStatus.OK);
    }

    @PostMapping("/addaf")
    public ResponseEntity<?> ShowAllUsers(@RequestBody Evenement pa ){
        service.ajouterAffecteEvenParticipe(pa);
        return new ResponseEntity<>( service.ajouterAffecteEvenParticipe(pa), HttpStatus.OK);
    }

    @PostMapping("/add/{desc}")
    public ResponseEntity<?> ShowAllUsers(@RequestBody Logistique pa, @PathVariable("desc") String desc){
        service.ajouterAffectLogEvnm(pa,desc);
        return new ResponseEntity<>(  service.ajouterAffectLogEvnm(pa,desc), HttpStatus.OK);
    }
    @GetMapping("/show/{deb}/{fin}")
    public ResponseEntity<?> ShowAllUsers(@PathVariable("deb") Date deb, @PathVariable("fin") Date fin){
        service.getLogistiqueDates(deb,fin);
        return new ResponseEntity<>( service.getLogistiqueDates(deb,fin), HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<?> ShowAllUsers(){
        service.getParReservLogis();
        return new ResponseEntity<>(  service.getParReservLogis(), HttpStatus.OK);
    }



}
