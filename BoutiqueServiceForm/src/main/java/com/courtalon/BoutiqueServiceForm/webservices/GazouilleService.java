package com.courtalon.BoutiqueServiceForm.webservices;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.courtalon.BoutiqueServiceForm.metier.Message;
import com.courtalon.BoutiqueServiceForm.repositories.MessageDAO;

public class GazouilleService {

	public static final String CENSORED = "twitter";
	
	@Autowired
	
	private MessageDAO messagedao;
	


	public MessageDAO getMessagedao() {
		return messagedao;
	}

	public void setMessagedao(MessageDAO messagedao) {
		this.messagedao = messagedao;
	}

	public Message publish(Message m) {
		Pattern p = Pattern.compile(CENSORED, Pattern.CASE_INSENSITIVE);
		m.setTitre(p.matcher(m.getTitre()).replaceAll("gazouille"));
		m.setCorps(p.matcher(m.getCorps()).replaceAll("gazouille"));
		getMessagedao().save(m);
		return m;
	}
	
	public Message readGazouille(int id) {
		Message m = getMessagedao().findById(id);
		if (m == null)
			throw new GazouilleNotFound("gazouille inconnue" );
		return m;
	}
	
	public List<Message> readAllGazouilles() {
		return getMessagedao().findAll();
	}
	
	
}
