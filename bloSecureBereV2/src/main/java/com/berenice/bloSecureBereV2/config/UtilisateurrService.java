package com.berenice.bloSecureBereV2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.berenice.bloSecureBereV2.repositories.UtilisateurRepository;
// a creer
public class UtilisateurrService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
		
		@Autowired
		private UtilisateurRepository utilisateuRepository;
		
		
		
		
	}

}
