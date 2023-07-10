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
@Table(name="address")
public class Address {

    @Id
    @Column(name="addressid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int addressid;


    @Column(name="empid")
    int empid;

    @NotBlank
    @Column(name="housename")
    String housename;

    @Column(name="place")
    String place;

    @Column(name="pincode")
    String pincode;

}
