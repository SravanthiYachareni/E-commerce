package com.sravs.ecommerce.graphql.model;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeInput {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String xid;
    private String pid;
    private String region;
    private String desk;
    private List<String> peregineRole;
    private boolean eidosEnabled;
    private List<String> eidosTeam;
    private List<String> eidosGroup;
}

