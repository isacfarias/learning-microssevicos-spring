package com.farias.hruser.entities;

import javax.persistence.Id;

import lombok.Data;

@Data
public class User {


    @Id
    private Long id;
    
}
