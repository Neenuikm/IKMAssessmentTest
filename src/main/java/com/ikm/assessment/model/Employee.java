package com.ikm.assessment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name="employe")
public class Employee {
    @Id
    @Column(name="empid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int empid;

    @NotBlank
    @Column(name="name")
    String name;

    @NotEmpty
    @Column(name="phone")
    String phone;


    @Past(message = "Birth date must be past date")
    @Column(name="dateOfBirth")
    Date dateOfBirth;

    @OneToOne
    @JoinColumn(name = "empid")
    private Address address;
}
