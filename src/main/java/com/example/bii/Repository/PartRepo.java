package com.example.bii.Repository;

import com.example.bii.Entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepo extends JpaRepository<Participant,Integer> {
}
