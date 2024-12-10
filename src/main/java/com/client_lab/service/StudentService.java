package com.client_lab.service;

import com.client_lab.dto.StudentDTO;
import com.client_lab.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();
    StudentDTO findByUsername(String username);

    StudentDTO createStudent(StudentDTO studentDTO);
}
