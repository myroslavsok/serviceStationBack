package com.example.demo.repositories;

import com.example.demo.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNameAndPhoneNumber(String name, String phoneNumber);
}
