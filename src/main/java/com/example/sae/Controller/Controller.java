package com.example.sae.Controller;

import com.example.sae.Entity.FamilleAct;
import com.example.sae.Entity.Pathologie;
import com.example.sae.Entity.Patient;
import com.example.sae.Service.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class Controller {
    @Autowired
    private Iservice service;



    @PostMapping("/addpathologie")
    public ResponseEntity<?> ShowAllUsers(@RequestBody Pathologie pa ){
        service.ajouterPathologie(pa);
        return new ResponseEntity<>( service.ajouterPathologie(pa), HttpStatus.OK);
    }

    @PostMapping("/addpatient/{id}")
    public ResponseEntity<?> test(@RequestBody Patient pa, @PathVariable("id") String code ){
        service.ajouterPatientEtAffecterAPathologie(pa,code);
        return new ResponseEntity<>( service.ajouterPatientEtAffecterAPathologie(pa,code), HttpStatus.OK);
    }

    @PostMapping("/ajouterfamille")
    public ResponseEntity<?> test(@RequestBody FamilleAct pa ){
        service.ajouterFamilleActeEtActeAssocie(pa);
        return new ResponseEntity<>( service.ajouterFamilleActeEtActeAssocie(pa), HttpStatus.OK);
    }
    @PostMapping("/affecteracte/{codeacte}/{codepath}")
    public ResponseEntity<?> test(@PathVariable("codeacte") String codeacte,@PathVariable("codepath") String codepath ){
        service.affecterActeAPathologie(codeacte,codepath);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/calcuer/{ident}")
    public ResponseEntity<?> test(@PathVariable("ident") String ident ){
        service.calculerFacture(ident);
        return new ResponseEntity<>(service.calculerFacture(ident), HttpStatus.OK);
    }


}
