package com.davutbudak.hrms.entities.concretes.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "staffs")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@PrimaryKeyJoinColumn(name = "user_id")
public class Staff extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
}
