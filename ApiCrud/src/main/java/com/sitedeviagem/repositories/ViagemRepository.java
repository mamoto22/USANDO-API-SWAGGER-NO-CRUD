package com.sitedeviagem.repositories;

import com.sitedeviagem.models.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ViagemRepository extends JpaRepository<Viagem, Long> {

}
