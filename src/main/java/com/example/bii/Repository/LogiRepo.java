package com.example.bii.Repository;

import com.example.bii.Entity.Logistique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogiRepo extends JpaRepository<Logistique,Integer> {
    public Logistique findByReserve(Boolean t);

}
