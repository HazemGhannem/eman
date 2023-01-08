package com.example.sae.Service;

import com.example.sae.Entity.Acte;
import com.example.sae.Entity.FamilleAct;
import com.example.sae.Entity.Pathologie;
import com.example.sae.Entity.Patient;
import com.example.sae.Repository.ActeRepo;
import com.example.sae.Repository.FamilleActeRpeo;
import com.example.sae.Repository.PathologieRepo;
import com.example.sae.Repository.PatientRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashSet;
import java.util.logging.Logger;

@AllArgsConstructor
@Slf4j
@org.springframework.stereotype.Service
public class Service implements Iservice {
    private PatientRepo patientRepo;
    private PathologieRepo pathologieRepo;
    private FamilleActeRpeo familleActRepo;
    private ActeRepo acteRepo;


    @Override
    public Pathologie ajouterPathologie(Pathologie pa) {
        return pathologieRepo.save(pa);
    }

    @Override
    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String code) {
        HashSet<Pathologie> da = new HashSet<>();
        da.add(pathologieRepo.findByCodePath(code));
        p.setPathologies(da);
        return patientRepo.save(p);
    }

    @Override
    public FamilleAct ajouterFamilleActeEtActeAssocie(FamilleAct f) {
        //acteRepo.saveAll(f.getActes());
        FamilleAct d= familleActRepo.save(f);
        for (Acte k: f.getActes()){
            k.setFamilleAct(f);
            System.out.println(k.getFamilleAct());

            acteRepo.save(k);
        }



        return d;
    }

    @Override
    public void affecterActeAPathologie(String codeAct, String codepath) {
        Acte acte = acteRepo.findByCodeActe(codeAct);
        Pathologie pathologie = pathologieRepo.findByCodePath(codepath);
        if (pathologie.getArchive() == null) {
            pathologie.getActes().add(acte);
            pathologieRepo.save(pathologie);
        }

    }

    @Override
    public float calculerFacture(String identifiant) {
        float F=0;
        for(Acte p : pathologieRepo.findByCodePathOrLibelle(identifiant,identifiant).getActes()){
            F += p.getPrexUnitaireActe()*p.getCotationActe();
        }
        return F;
    }

    @Scheduled(cron =" 0/30 * * * * *")
    public void calculerNumberActesParPathologie(){
        for (Pathologie p : pathologieRepo.findAll()) {
            log.info(p + " " + p.getActes().size());
        }
    }
}
