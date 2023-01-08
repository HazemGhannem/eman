package com.example.sae.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Acte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActe;
    private String codeActe;
    private int cotationActe;
    private float prexUnitaireActe;
    private String desgnationActe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private FamilleAct familleAct;

    @ManyToMany(mappedBy = "actes")
    @JsonIgnore
    private Set<Pathologie> pathologies;


}
