package com.OpticienPFE.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OpticienPFE.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	List<Client> findByNomPrenom(String nomPrenom);

	
}
