package com.davutbudak.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "personnel")
@AllArgsConstructor
@NoArgsConstructor
public class Personnel extends User{

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
}
