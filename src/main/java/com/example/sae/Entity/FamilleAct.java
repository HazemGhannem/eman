package com.example.sae.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamilleAct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFA;

    private String codeFA;
    private String libelle;
    private String description;

    @OneToMany(mappedBy = "familleAct" ,cascade = CascadeType.ALL)
    private Set<Acte> actes;



}
