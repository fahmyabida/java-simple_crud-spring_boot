package com.example.sk_uiiPersonal.repository;

import com.example.sk_uiiPersonal.model.Faculties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultiesRepository extends JpaRepository<Faculties, Integer> {

}
