package com.speechanalysis.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by pmusset on 6/22/16.
 */
@Entity(name = "system")
public class System {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idsys")
    private Integer idSys;

    @Column(name = "namesys")
    private String nameSys;

    @Column(name = "version")
    private String version;

    @Column(name="datesys")
    private Date dateSys;

    @Column(name="supervisor")
    private Integer supervisor;

    @Column(name = "description")
    private String description;

    public Integer getIdSys() {
        return idSys;
    }

    public void setIdSys(Integer idSys) {
        this.idSys = idSys;
    }

    public String getNameSys() {
        return nameSys;
    }

    public void setNameSys(String nameSys) {
        this.nameSys = nameSys;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getDateSys() {
        return dateSys;
    }

    public void setDateSys(Date dateSys) {
        this.dateSys = dateSys;
    }

    public Integer getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Integer supervisor) {
        this.supervisor = supervisor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
