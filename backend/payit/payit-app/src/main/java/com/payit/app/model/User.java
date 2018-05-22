package com.payit.app.model;

import com.payit.security.model.Credentials;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Credentials fkCredentials;
    private String email;
    private String firstName;
    private String lastName;
    private String profilePic;
}
