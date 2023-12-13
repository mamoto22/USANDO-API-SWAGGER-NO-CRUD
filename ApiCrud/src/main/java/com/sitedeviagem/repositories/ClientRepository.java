package com.sitedeviagem.repositories;

import com.sitedeviagem.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClientRepository extends JpaRepository<Client, Long> {

}
