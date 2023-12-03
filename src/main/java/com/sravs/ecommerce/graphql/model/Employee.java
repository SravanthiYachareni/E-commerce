package com.sravs.ecommerce.graphql.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Employee {
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

