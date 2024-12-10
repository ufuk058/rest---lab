package com.client_lab.controller;

import com.client_lab.dto.ResponseWrapper;
import com.client_lab.dto.TeacherDTO;
import com.client_lab.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
/*
           Endpoint: /api/v1/teacher

           JSON Response Body:
           <teachers data>
        */

    @GetMapping("/all")
    public List<TeacherDTO> getAllTeachers(){

      return  teacherService.findAll();
    }


        /*
           Endpoint: /api/v1/teacher/{username}
           HTTP Status Code: 200

           JSON Response Body:
           "success": true
           "message": "Teacher is successfully retrieved."
           "code":200
           "data":<teacher data>
        */

    @GetMapping("/{username}")
    public ResponseEntity<ResponseWrapper> getTeacherByUsername(@PathVariable String username){

        return ResponseEntity.ok(ResponseWrapper.builder()
                .success(true)
                .message("Teacher: -"+username+"- successfully retrieved")
                .code(HttpStatus.OK.value())
                .data(teacherService.findByUsername(username)).build());
    }
       /*
           Endpoint: /api/v1/teacher
           HTTP Status Code: 201
           Custom Response Header: "teacherUsername", <created username>

           JSON Response Body:
           "success": true
           "message": "Teacher is successfully created."
           "code":201
           "data":<created teacher data>
     */

    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper> createNewTeacher(@RequestBody TeacherDTO teacherDTO){

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("teacherUsername", teacherDTO.getUsername())
                .body(ResponseWrapper.builder()
                        .success(true)
                        .message("New teacher Successfully Created")
                        .code(HttpStatus.CREATED.value())
                        .data(teacherService.createTeacher(teacherDTO)).build());
    }
}
