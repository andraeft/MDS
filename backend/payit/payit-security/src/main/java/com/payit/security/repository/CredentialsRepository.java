package com.payit.security.repository;


import com.payit.security.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CredentialsRepository extends JpaRepository<Credentials,String>{

}
