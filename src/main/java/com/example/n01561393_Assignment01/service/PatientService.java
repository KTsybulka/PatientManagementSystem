package com.example.n01561393_Assignment01.service;

import com.example.n01561393_Assignment01.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatientService {

    public void addPatient(Patient patient);

    public List<Patient> getAllPatients();

    public Patient getPatientById(int id);

    public void updatePatient(Patient patient);

    public void deletePatient(int id);

//    public Patient getPatientByName(String name);

}
