package com.desafio.zup.model;

import com.desafio.zup.dto.CreatorItemDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CreatorModel {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    public CreatorModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private String role;
    private String resourceURI;

    public void toCreator(CreatorItemDTO creatorItemDTO){
        this.setName(creatorItemDTO.getName());
        this.setResourceURI(creatorItemDTO.getResourceURI());
        this.setRole(creatorItemDTO.getRole());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }
}
