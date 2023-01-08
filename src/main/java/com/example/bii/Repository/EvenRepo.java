package com.example.bii.Repository;

import com.example.bii.Entity.Evenement;
import com.example.bii.Entity.Logistique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EvenRepo extends JpaRepository<Evenement,Integer> {
    public Evenement findByDescription(String desc);

    public List<Evenement> findByBetweenDateDebutAndDateFin(Date db, Date df);
}
