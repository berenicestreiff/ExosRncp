package com.berenice.bloSecureBereV2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.berenice.bloSecureBereV2.metier.Role;

public interface RoleRepository  extends CrudRepository<Role, Integer> {

	Role findByRoleName(String roleName);}
	
	
	

	
