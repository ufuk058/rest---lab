package com.client_lab.service;

import com.client_lab.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> findAll();
    TeacherDTO findByUsername(String username);
    TeacherDTO createTeacher(TeacherDTO teacherDTO);
}
