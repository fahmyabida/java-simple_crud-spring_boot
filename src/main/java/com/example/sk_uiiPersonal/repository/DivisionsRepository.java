package com.example.sk_uiiPersonal.repository;

import com.example.sk_uiiPersonal.model.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionsRepository extends JpaRepository<Divisions, Integer> {

}
