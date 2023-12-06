package com.sravs.ecommerce.graphql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String xid;

    private String pid;

    private String region;

    private String desk;

//    @ElementCollection
//    private List<String> peregineRole;

    private boolean eidosEnabled;
    public String getEmail() {
        return email;

    }
//    @ElementCollection
//    private List<String> eidosTeam;

//    @ElementCollection
//    private List<String> eidosGroup;
}
