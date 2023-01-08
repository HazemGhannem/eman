package com.example.bii.Service;

import com.example.bii.Entity.Evenement;
import com.example.bii.Entity.Logistique;
import com.example.bii.Entity.Participant;

import java.util.Date;
import java.util.List;

public interface Iservice {

    public Participant ajouterParticipant(Participant p);
    public Evenement ajouterAffecteEvenParticipe(Evenement e);
    public Logistique ajouterAffectLogEvnm(Logistique l, String descrip);
    public List<Logistique> getLogistiqueDates(Date datedeb, Date datefin);

    public List<Participant> getParReservLogis();
    public void calculCout();
}
