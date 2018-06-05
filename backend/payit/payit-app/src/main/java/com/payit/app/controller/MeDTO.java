package com.payit.app.controller;

import lombok.Data;

@Data
class MeDTO {
    private Integer id;
    private String profilePic = "852ad2f0-4061-413d-b56a-8f9305ab70a9";
    private Float bankRating = 5f;
    private Float slaveRating = 5f;
    private String firstName;
    private String lastName;
    private String email;
}
