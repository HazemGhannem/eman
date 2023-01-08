package com.example.bii.Service;

import com.example.bii.Entity.Evenement;
import com.example.bii.Entity.Logistique;
import com.example.bii.Entity.Participant;
import com.example.bii.Entity.Tache;
import com.example.bii.Repository.EvenRepo;
import com.example.bii.Repository.LogiRepo;
import com.example.bii.Repository.PartRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service implements Iservice{
    private EvenRepo evenRepo;
    private LogiRepo logiRepo;
    private PartRepo partRepo;

    @Override
    public Participant ajouterParticipant(Participant p) {
        return partRepo.save(p);
    }

    @Override
    public Evenement ajouterAffecteEvenParticipe(Evenement e) {
        Evenement k = evenRepo.save(e);
        HashSet<Evenement> even = new HashSet<>();
        even.add(k);
        for (Participant p : k.getParticipants()){
            p.setEvenements(even);
            partRepo.save(p);
        }
        return k;
    }

    @Override
    public Logistique ajouterAffectLogEvnm(Logistique l, String descrip) {
        Evenement e = evenRepo.findByDescription(descrip);
        HashSet<Logistique> log = new HashSet<>();
        log.add(l);
        e.setLogistiques(log);
        evenRepo.save(e);
        return logiRepo.save(l);

    }

    @Override
    public List<Logistique> getLogistiqueDates(Date datedeb, Date datefin) {
        List<Logistique> log = new ArrayList<>();
        evenRepo.findByBetweenDateDebutAndDateFin(datedeb,datefin);
        for (Evenement even : evenRepo.findByBetweenDateDebutAndDateFin(datedeb,datefin)){
            log.addAll(even.getLogistiques());

        }
        return log;
    }

    @Override

    public List<Participant> getParReservLogis() {
        List<Logistique> l =new ArrayList<>();
        List<Participant> h = new ArrayList<>();

        for(Participant p :partRepo.findAll()){
           if(p.getTache()==(Tache.ORGANISATEUR)) {
               for (Evenement ev : p.getEvenements()){
               l.addAll(evenRepo.findById(ev.getId()).get().getLogistiques());
                }
               for (Logistique k :l){
                   if (k.getReserve()==false){
                       h.add(p);
                   }

               }
           }
        }

        return h;
    }

    @Override
    @Scheduled(cron =" 0/60 * * * * *")
    public void calculCout() {
        float prix=0;
        List<Logistique> log = new ArrayList<>();
        for (Evenement ev: evenRepo.findAll()){
            log.addAll(ev.getLogistiques());
        }
        for (Logistique l : log){
          if( l.getReserve()==true) {
             prix+= l.getPrixUnit();
          }
        }
        System.out.println(prix);
    }

}
