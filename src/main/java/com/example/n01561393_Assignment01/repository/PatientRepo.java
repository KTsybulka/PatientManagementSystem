package com.example.n01561393_Assignment01.repository;

import com.example.n01561393_Assignment01.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository <Patient, Integer> {

    List<Patient> findByName(String name);

    @Query(value = "SELECT * FROM patient WHERE age > 30 ORDER BY name, age", nativeQuery = true)
    List<Patient> findByNativeQuery();;
}
