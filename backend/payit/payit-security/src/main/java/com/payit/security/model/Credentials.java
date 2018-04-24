package com.payit.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Data
@Entity
public class Credentials {
    private String username;
    private String password;
    @Id
    private String id;
}
