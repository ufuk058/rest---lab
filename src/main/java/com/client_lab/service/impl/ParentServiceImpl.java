package com.client_lab.service.impl;

import com.client_lab.dto.ParentDTO;
import com.client_lab.entity.Parent;
import com.client_lab.repository.ParentRepository;
import com.client_lab.service.ParentService;
import com.client_lab.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final MapperUtil mapperUtil;

    public ParentServiceImpl(ParentRepository parentRepository, MapperUtil mapperUtil) {
        this.parentRepository = parentRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<ParentDTO> findAll() {
        List<Parent> allParents= parentRepository.findAll();
        return allParents.stream().map(parent -> mapperUtil.convert(parent, new ParentDTO()))
                .collect(Collectors.toList());
    }
}
