package com.speechanalysis.service;

import com.speechanalysis.model.Txt;
import com.speechanalysis.repository.TxtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pmusset on 6/21/16.
 */
@Service
public class TxtServiceImpl implements TxtService {
    private TxtRepository txtRepository;

    @Autowired
    public void setTxtRepository(TxtRepository txtRepository){
        this.txtRepository=txtRepository;
    }

    @Override
    public Iterable<Txt> listAllTxts() {
        return txtRepository.findAll();
    }
}
