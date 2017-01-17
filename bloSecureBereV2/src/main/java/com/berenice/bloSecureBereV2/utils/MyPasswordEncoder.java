package com.berenice.bloSecureBereV2.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder implements PasswordEncoder {



		private BCryptPasswordEncoder pe;
		
		public MyPasswordEncoder() {
			pe = new BCryptPasswordEncoder();
		}
		// sauvegarde new mdp en le cryptant
		
		@Override
		public String encode(CharSequence rawPassword) {
			return pe.encode(rawPassword);
		}
// permet de se logger avec raw password et encoded password
		//on calcule rawpassword et fait le match entre les deux.c'est le bcrypt qui fait entre autre chose el salage
		@Override
		public boolean matches(CharSequence rawPassword, String encodedPassword) {
			return pe.matches(rawPassword, encodedPassword);
		}

	}
	

