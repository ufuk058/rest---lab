package com.client_lab.service.impl;

import com.client_lab.dto.StudentDTO;
import com.client_lab.entity.Student;
import com.client_lab.exception.AlreadyExistsException;
import com.client_lab.exception.NotFoundException;
import com.client_lab.repository.AddressRepository;
import com.client_lab.repository.ParentRepository;
import com.client_lab.repository.StudentRepository;
import com.client_lab.repository.TeacherRepository;
import com.client_lab.service.StudentService;
import com.client_lab.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
   private final StudentRepository studentRepository;
   private final MapperUtil mapperUtil;
   private final AddressRepository addressRepository;
   private final ParentRepository parentRepository;
   private final TeacherRepository teacherRepository;

    public StudentServiceImpl(StudentRepository studentRepository, MapperUtil mapperUtil,
                              AddressRepository addressRepository, ParentRepository parentRepository,
                              TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.mapperUtil = mapperUtil;
        this.addressRepository = addressRepository;
        this.parentRepository = parentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student> allStudents= studentRepository.findAll();
        return allStudents.stream().map(student-> mapperUtil.convert(student, new StudentDTO()))
                .collect(Collectors.toList());
    }


    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Optional<Student> foundStudent= studentRepository.findByUsername(studentDTO.getUsername());

        if(foundStudent.isPresent()){
            throw new AlreadyExistsException("Student Already Exist!");
        }
        addressRepository.findByAddressNo(studentDTO.getAddressNo())
                .orElseThrow(()->new NotFoundException("Address not found!"));
        parentRepository.findByUsername(studentDTO.getParent())
                .orElseThrow(()->new  NotFoundException("Parent not found!"));
        teacherRepository.findByUsername(studentDTO.getTeacher())
                .orElseThrow(() -> new NotFoundException("Teacher not found!"));
        Student studentToSave= mapperUtil.convert(studentDTO, new Student());
        Student savedStudent=studentRepository.save(studentToSave);

        return mapperUtil.convert(savedStudent, new StudentDTO());
    }
}
