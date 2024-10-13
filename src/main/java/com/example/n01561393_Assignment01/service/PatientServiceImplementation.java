package com.example.n01561393_Assignment01.service;

import com.example.n01561393_Assignment01.entity.Patient;
import com.example.n01561393_Assignment01.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImplementation implements PatientService {

    private final PatientRepo patientRepo;

    public PatientServiceImplementation(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override
    public void addPatient(Patient patient){
        patientRepo.save(patient);
    }

    @Override
    public List<Patient> getAllPatients(){
        return patientRepo.findAll() ;
    }

    @Override
    public Patient getPatientById(int id){
        return patientRepo.getReferenceById(id);
    }

    @Override
    public void updatePatient(Patient patient){
        patientRepo.save(patient);
    }

    @Override
    public void deletePatient(int id){
        patientRepo.deleteById(id);
    }

    public List<Patient> getPatientByName(String name){
        return patientRepo.findByName(name);
    }

    public List<Patient> getPatientByNativeQuery() {
        return patientRepo.findByNativeQuery();
    }
}
