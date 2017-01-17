package com.berenice.bloSecureBereV2.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.berenice.bloSecureBereV2.metier.Role;
import com.berenice.bloSecureBereV2.metier.Utilisateur;
import com.berenice.bloSecureBereV2.repositories.MessageRepository;
import com.berenice.bloSecureBereV2.repositories.RoleRepository;
import com.berenice.bloSecureBereV2.repositories.UtilisateurRepository;
//important
@Service
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
				// undescore important
				Role r1 = new Role(0, "ROLE_ADMIN");
				r1 = roleRepository.save(r1);
		
				
				// utilisateur par defaut
				// pour bonne pratique, il faudrait forcer
				// a reinitialiser le mot de passe a la première connection
				Utilisateur u1 = new Utilisateur(0,
												"admin",
												"admin@admin.org",
												myPasswordEncoder.encode("admin1234"),
												true);
			
				
				utilisateurRepository.save(u1);
// get ajouts
			
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

