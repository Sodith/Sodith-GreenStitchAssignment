package com.Sodith.GreenStitch.Modal;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 8, max = 50)
    private String userName;
    @NotBlank
    @Size(min = 3, max = 50)
    private String password;
    @NotBlank
    @Size(min = 3, max = 50)
    private String first_Name;
    @NotBlank
    @Size(min = 3, max = 50)
    private String last_Name;
    @NotBlank
    @Size(min = 2, max = 50)
    private String position;
    @NotBlank
    @Size(min = 3, max = 10)
    private String deptarment;


}
