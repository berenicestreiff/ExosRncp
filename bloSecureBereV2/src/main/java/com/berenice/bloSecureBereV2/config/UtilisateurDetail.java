package com.berenice.bloSecureBereV2.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.berenice.bloSecureBereV2.metier.Utilisateur;
// pas besoin @componenent
// encapsule un auteur
public class UtilisateurDetail implements UserDetails {
	
	private Utilisateur utilisateur;
	
	

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
// à modifier, attention utilisateur /auteur
	//renvoie les roles sous la forme de granted autority
	//car spring security ne raisonne qu'ne matiere de role et d'autority
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return utilisateur.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return utilisateur.getUsername();
	}

	// true car notre compte ici n'expire jamais.
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
// intervient au bout d'un temps qd un mdp a expiré, ex au bout de 6 mois, 
	//credential inclut plus que le password, inclut tt ce qui prouve identitié utilisateur
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return utilisateur.isEnabled();
	}
}
	

	