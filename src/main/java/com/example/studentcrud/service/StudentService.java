package com.example.studentcrud.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;

@Service
public class StudentService{

    private final StudentRepository repo;

    public StudentService(StudentRepository repo){
        this.repo=repo;

    }

    public List<Student> getAll(){
        return repo.findAll();
    }

    public Student save(Student s){

        return repo.save(s);

    }

    public Student update(String id, Student s){

        Student e=repo.findById(id).orElseThrow();
        e.setName(s.getName());
        e.setEmail(s.getEmail());

        return repo.save(e);
    }

    public void delete(String id){
        repo.deleteById(id);
    }
}