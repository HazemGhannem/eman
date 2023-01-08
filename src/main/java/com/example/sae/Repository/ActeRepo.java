package com.example.sae.Repository;

import com.example.sae.Entity.Acte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeRepo extends JpaRepository<Acte,Long> {
    public Acte findByCodeActe(String code);
}
