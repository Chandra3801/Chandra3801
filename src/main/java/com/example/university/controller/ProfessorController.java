package com.example.university.controller;
import com.example.university.model.*;

import com.example.university.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ProfessorController{

    @Autowired
    public ProfessorJpaService professorJpaService;

    @GetMapping("/professor")
    public ArrayList<Professor> getProfessors(){
        return professorJpaService.getProfessors();
    }

    @GetMapping("/professors/{professorId}/courses")
    public List<Course> getProfessorCourse(@PathVariable("professorId") int professorId){
        return professorJpaService.getProfessorCourseName(professorId);
    }

    @GetMapping("/professors/{professorsId}")
    public Professor getProfessorById(@PathVariable("professorId") int professorId){
        return professorJpaService.getProfessorById(professorId);
    }

    @PostMapping("/professors")
    public Professor addProfessor(@RequestBody Professor professor){
        return professorJpaService.addService(professor);
    }

    @PutMapping("/professors/{professorId}")
    public Professor updateProfessor(@PathVariable("professorId") int professorId, @RequestBody Professor professor){
        return professorJpaService.updateProfessor(professorId, professor);
    }

    @DeleteMapping("/professors/{professorId}")
    public void deleteProfessor(@PathVariable("professorId") int professorId){
        professorJpaService.deleteProfessor(professorId);
    }
}
