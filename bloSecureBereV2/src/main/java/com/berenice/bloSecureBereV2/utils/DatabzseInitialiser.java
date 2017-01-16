package com.berenice.bloSecureBereV2.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.berenice.bloSecureBereV2.metier.Role;
import com.berenice.bloSecureBereV2.metier.Utilisateur;
import com.berenice.bloSecureBereV2.repositories.MessageRepository;
import com.berenice.bloSecureBereV2.repositories.RoleRepository;
import com.berenice.bloSecureBereV2.repositories.UtilisateurRepository;

public class DatabzseInitialiser implements ApplicationListener<ContextRefreshedEvent> {

		@Autowired
		private UtilisateurRepository utilisateurRepository;
		
		@Autowired
		private RoleRepository roleRepository;
		
		@Autowired
		private MessageRepository messageRepository;
		
		@Autowired
		private MyPasswordEncoder myPasswordEncoder;
		
		@Override
		public void onApplicationEvent(ContextRefreshedEvent arg0) {
			if (utilisateurRepository.count() == 0) {
				// la base est vide, creons les utilisateurs de base
				//BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
				
				Role r1 = new Role(0, "ROLE_ADMIN");
				Role r2 = new Role(0, "ROLE_USER");
				r1 = roleRepository.save(r1);
				r2 = roleRepository.save(r2);
				
				// utilisateur par defaut
				// pour bonne pratique, il faudrait forcer
				// a reinitialiser le mot de passe a la première connection
				Utilisateur u1 = new Utilisateur(0,
												"admin",
												"admin@admin.org",
												myPasswordEncoder.encode("admin"),
												true);
				Utilisateur u2 = new Utilisateur(0,
						"patrick",
						"patrick@admin.org",
						myPasswordEncoder.encode("toto1234"),
						true);
				// admin a les 2 roles
				u1.getRoles().add(r1);
				u1.getRoles().add(r2);
				// patrick est seulement utilisateur
				u2.getRoles().add(r2);
				
				utilisateurRepository.save(u1);
				utilisateurRepository.save(u2);
			
			}
		}

		public UtilisateurRepository getUtilisateurRepository() {
			return utilisateurRepository;}

		public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
			this.utilisateurRepository = utilisateurRepository;}

		public RoleRepository getRoleRepository() {
			return roleRepository;}

		public void setRoleRepository(RoleRepository roleRepository) {
			this.roleRepository = roleRepository;	}

		public MessageRepository getMessageRepository() {
			return messageRepository;}

		public void setMessageRepository(MessageRepository messageRepository) {
			this.messageRepository = messageRepository;}

	}

