package com.example.sae.Service;

import com.example.sae.Entity.FamilleAct;
import com.example.sae.Entity.Pathologie;
import com.example.sae.Entity.Patient;

public interface Iservice {

    public Pathologie ajouterPathologie(Pathologie pa);
    public Patient ajouterPatientEtAffecterAPathologie(Patient p , String code);
    public FamilleAct ajouterFamilleActeEtActeAssocie(FamilleAct f);
    public void affecterActeAPathologie(String codeAct,String codepath);
    public float calculerFacture(String identifiant);

}
