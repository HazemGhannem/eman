package com.example.sae.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String identifiantPieceIdentite;
    @Temporal(TemporalType.DATE)
    private Date dateEmission;
    private String nomP;
    private String prenomP;
    @Enumerated(EnumType.STRING)
    private TypePieceIdentite typePieceIdentite;

    @ManyToMany
    @JsonIgnore
    private Set<Pathologie> pathologies;
}
