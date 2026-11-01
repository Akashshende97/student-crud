package com.example.studentcrud.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins="http://localhost:3000")
public class StudentController{

    private final StudentService service;
    public StudentController(StudentService service){

        this.service=service;
    }

    @GetMapping
    public List<Student> getAll(){

        return service.getAll();
    }

    @PostMapping
    public Student create(@RequestBody Student s){

        return service.save(s);

    }

    @PutMapping("/{id}")
    public Student update(@PathVariable String id,@RequestBody Student s){

        return service.update(id,s);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){

        service.delete(id);
    }
}