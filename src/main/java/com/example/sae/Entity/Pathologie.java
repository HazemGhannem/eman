package com.example.sae.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pathologie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPath;
    private String codePath;
    private String libelle;
    private String description;
    private Boolean archive;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Acte> actes;

}
