package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public interface RepoStudent extends CrudRepository<Student, Integer>{

}
