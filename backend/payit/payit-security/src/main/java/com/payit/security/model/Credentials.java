package com.payit.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credentials")
public class Credentials {
    @Id
    private String id;
    private String username;
    private String password;
}
