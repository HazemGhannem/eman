package com.example.sae.Repository;

import com.example.sae.Entity.Pathologie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PathologieRepo extends JpaRepository<Pathologie,Long> {

    public Pathologie findByCodePath(String code);
    public Pathologie findByCodePathOrLibelle(String code,String label);
}
