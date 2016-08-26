package com.speechanalysis.loader;

import com.speechanalysis.model.Txt;
import com.speechanalysis.repository.TxtRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by plam on 20/07/16.
 */
@Component
public class TxtLoader implements ApplicationListener<ContextRefreshedEvent>{
    private TxtRepository txtRepository;

    private Logger log = Logger.getLogger(TxtLoader.class);

    @Autowired
    public void setTxtRepository(TxtRepository txtRepository){
        this.txtRepository = txtRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        Txt txt1 = new Txt();
        txt1.setUrl("blabla.com/blabla");
        txtRepository.save(txt1);

        Txt txt2 = new Txt();
        txt2.setUrl("blabla.com/yohoohoh");
        txtRepository.save(txt2);
    }
}
