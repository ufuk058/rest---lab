package com.client_lab.controller;

import com.client_lab.dto.ResponseWrapper;
import com.client_lab.dto.StudentDTO;
import com.client_lab.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
/*
           Endpoint: /api/v1/student
           HTTP Status Code: 200

           JSON Response Body:
           "success": true
           "message": "Students are successfully retrieved."
           "code":200
           "data":<students data>
     */

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllStudents(){

        return ResponseEntity.ok(ResponseWrapper.builder()
                .success(true)
                .message("Successfully retrieved")
                .code(HttpStatus.OK.value())
                .data(studentService.findAll()).build());
    }


    /*
          Endpoint: /api/v1/student
          HTTP Status Code: 201

          JSON Response Body:
          "success": true
          "message": "Student is successfully created."
          "code":201
          "data":<created student data>
    */

    @GetMapping("/{username}")
    public ResponseEntity<ResponseWrapper> getStudentByUsername(@PathVariable String username){

        return ResponseEntity.ok(ResponseWrapper.builder()
                .success(true)
                .message("Student: "+ username+" successfully retrieved")
                .code(HttpStatus.OK.value())
                .data(studentService.findByUsername(username)).build());
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper> createNewStudent(@RequestBody StudentDTO studentDTO){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseWrapper.builder()
                        .success(true)
                        .message("New Student Successfully Created")
                        .code(HttpStatus.CREATED.value())
                        .data(studentService.createStudent(studentDTO)).build());
    }
}
