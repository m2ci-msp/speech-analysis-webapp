package com.speechanalysis.model;

import javax.persistence.*;

/**
 * Created by pmusset on 7/8/16.
 */

@Entity(name = "voice")
public class Voice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idvoice")
    private Integer idVoice;

    @Column(name = "namevoice")
    private String nameVoice;

    @Column(name = "system")
    private Integer system;

    public Integer getIdVoice() {
        return idVoice;
    }

    public void setIdVoice(Integer idVoice) {
        this.idVoice = idVoice;
    }

    public String getNameVoice() {
        return nameVoice;
    }

    public void setNameVoice(String nameVoice) {
        this.nameVoice = nameVoice;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
