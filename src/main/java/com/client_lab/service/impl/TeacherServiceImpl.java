package com.client_lab.service.impl;

import com.client_lab.dto.TeacherDTO;
import com.client_lab.entity.Teacher;
import com.client_lab.exception.AlreadyExistsException;
import com.client_lab.exception.NotFoundException;
import com.client_lab.repository.AddressRepository;
import com.client_lab.repository.TeacherRepository;
import com.client_lab.service.TeacherService;
import com.client_lab.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public TeacherServiceImpl(TeacherRepository teacherRepository, AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.teacherRepository = teacherRepository;
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<TeacherDTO> findAll() {
        List<Teacher> allTeachers= teacherRepository.findAll();
        return allTeachers.stream().map(teacher -> mapperUtil.convert(teacher, new TeacherDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO findByUsername(String username) {
       Teacher foundTeacher = teacherRepository.findByUsername(username)
               .orElseThrow(()-> new NotFoundException("Teacher not found!"));

       return mapperUtil.convert(foundTeacher, new TeacherDTO());
    }

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {

        Optional<Teacher> foundTeacher= teacherRepository.findByUsername(teacherDTO.getUsername());
        if(foundTeacher.isPresent()){
            throw new AlreadyExistsException("Teacher already exist!");
        }

        addressRepository.findByAddressNo(teacherDTO.getAddressNo())
                .orElseThrow(()-> new NotFoundException("Address not found!"));
        Teacher teacherToSave=mapperUtil.convert(foundTeacher, new Teacher());
        Teacher savedTeacher= teacherRepository.save(teacherToSave);


        return mapperUtil.convert(savedTeacher, new TeacherDTO());
    }
}
