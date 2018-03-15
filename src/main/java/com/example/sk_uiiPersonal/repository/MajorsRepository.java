package com.example.sk_uiiPersonal.repository;

import com.example.sk_uiiPersonal.model.Majors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorsRepository extends JpaRepository<Majors, Integer> {

}