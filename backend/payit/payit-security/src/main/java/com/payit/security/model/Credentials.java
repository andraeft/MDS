package com.payit.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;

@AllArgsConstructor
@Data
@Entity
public class Credentials {
    private String username;
    private String password;
    private String id;
}
