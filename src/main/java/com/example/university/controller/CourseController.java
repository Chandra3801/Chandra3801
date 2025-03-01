package com.example.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.university.service.CourseJpaService;
import com.example.university.model.*;

import java.util.*;

@RestController
public class CourseController {
    @Autowired
    public CourseJpaService CourseJpaService;

    @GetMapping("/courses")
    public ArrayList<Course> getCourses() {
        return courseJpaService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable("courseId") int courseId) {
        return courseJpaService.getCourseById(courseId);
    }

    @PostMapping("/courses/{courseId}")
    public Course addCourse(@RequestBody Course course) {
        return courseJpaService.addCourse(course);
    }

    @PutMapping("/courses/{courses}")
    public Course updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course course) {
        return courseJpaService.updateCourse(courseId, course);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") int courseId) {
        courseJpaService.deleteCourse(courseId);
    }

    @GetMapping("/courses/{courseId}/professor")
    public Professor getProfessorOfCourse(@PathVariable("courseId") int courseId) {
        return courseJpaService.getProfessorOfCourse(courseId);
    }

    @GetMapping("/courses/{courseId}/students")
    public List<Student> getStudentsOfCourse(@PathVariable("courseId") int courseId) {
        return courseJpaService.getStudentsOfCourse(courseId);
    }

}