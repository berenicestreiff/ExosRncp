package com.berenice.bloSecureBereV2.metier;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Message {
	
	private int id;
	private String titre;
	private String corps;
	
	private Utilisateur auteurs;
	

	@ManyToOne
	public Utilisateur getAuteurs() {
		return auteurs;
	}
	public void setAuteurs(Utilisateur auteurs) {
		this.auteurs = auteurs;
	}
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
	public Message(int id, String titre, String corps) {
		super();
		this.id = id;
		this.titre = titre;
		this.corps = corps;
	}
	
	
	public Message (){this(0,"","");}

}
