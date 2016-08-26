package com.speechanalysis.model;

import javax.persistence.*;

/**
 * Created by pmusset on 6/15/16.
 */
@Entity(name="txt")
public class Txt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idtxt")
    private Integer idTxt;

    @Column(name = "url")
    private String url;

    public Integer getIdTxt() {
        return idTxt;
    }

    public String getUrl() {
        return url;
    }

    public void setIdTxt(Integer idTxt) {
        this.idTxt = idTxt;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
