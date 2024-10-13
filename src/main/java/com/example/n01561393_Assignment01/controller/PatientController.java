package com.example.n01561393_Assignment01.controller;

import com.example.n01561393_Assignment01.entity.Patient;
import com.example.n01561393_Assignment01.service.PatientServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    private PatientServiceImplementation patientServiceImplementation;

    public PatientController(PatientServiceImplementation patientServiceImplementation) {
        this.patientServiceImplementation = patientServiceImplementation;
    }

    @GetMapping("/")
    public String getAllPatients(Model model){
        model.addAttribute("patientList", patientServiceImplementation.getAllPatients());
        return "index";
    }

    @GetMapping("/showAddPatientForm")
    public String showAddPatientForm(Model model){
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping("/addPatient")
    public String addPatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "addPatient";
        }

        patientServiceImplementation.addPatient(patient);
        return "redirect:/";
    }


    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable("id") int id){
        patientServiceImplementation.deletePatient(id);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model){
        Patient patient = patientServiceImplementation.getPatientById(id);
        model.addAttribute("patient", patient);
        return "updatePatientForm";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(@ModelAttribute("patient") Patient patient){
        patientServiceImplementation.updatePatient(patient);
        return "redirect:/";
    }

    @GetMapping("/searchPatientByName")
    public String searchPatientByName(@RequestParam String patientName, Model model){

        model.addAttribute("patientList",  patientServiceImplementation.getPatientByName(patientName));

        return "index";
    }


    @GetMapping("/searchPatientById")
    public String searchPatientById(@RequestParam int patientId, Model model){
        model.addAttribute("patientList",  patientServiceImplementation.getPatientById(patientId));
        return "index";
    }


    @GetMapping("/searchPatientByNativeQuery")
    public String searchPatientByNativeQuery(Model model){
        model.addAttribute("patientList", patientServiceImplementation.getPatientByNativeQuery());
        return "index";
    }

}
