package com.speechanalysis.service;

import com.speechanalysis.model.System;
import com.speechanalysis.repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pmusset on 6/22/16.
 */

@Service
public class SystemServiceImpl implements SystemService{
    private SystemRepository systemRepository;

    @Autowired
    public void setSystemRepository(SystemRepository systemRepository){
        this.systemRepository=systemRepository;
    }

    @Override
    public Iterable<System> listAll(){
        return systemRepository.findAll();
    }
}
