package com.codecool.elproyectegrande.model.cooperator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleGenerator")
    @SequenceGenerator(name = "roleGenerator", sequenceName = "role_seq")
    private Long id;

    private String name;
}