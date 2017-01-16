package com.berenice.bloSecureBereV2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.berenice.bloSecureBereV2.metier.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
		
		Utilisateur findByUsername(String username);

	}


