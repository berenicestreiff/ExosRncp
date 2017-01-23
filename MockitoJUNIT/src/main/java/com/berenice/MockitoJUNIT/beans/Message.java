package com.berenice.MockitoJUNIT.beans;


public class Message {
	private String titre;
	private String corps;
	
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
	
	
	
	
	public Message(String titre, String corps) {
		super();
		this.titre = titre;
		this.corps = corps;
	}
	
	public Message(){this("","");}
	
	@Override
	public String toString() {
		return "Message [titre=" + titre + ", corps=" + corps + "]";
	}
	
	
}
