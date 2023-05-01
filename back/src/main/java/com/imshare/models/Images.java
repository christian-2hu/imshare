package com.imshare.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String filename;

    @Column(name="data_created")
    private Long dataCreated;

    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getFilename() {
        return this.filename;
    }

    public void setDataCreated(Long date) {
        this.dataCreated = date;
    }

    public Long getDataCreated() {
        return this.dataCreated;
    }
    
}
