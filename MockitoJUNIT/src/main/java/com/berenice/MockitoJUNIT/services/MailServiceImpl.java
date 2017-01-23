package com.berenice.MockitoJUNIT.services;

import java.util.List;

import com.berenice.MockitoJUNIT.beans.Message;

public class MailServiceImpl implements MailService {
	// dit où le message est envoyé et dit à qui envoyer le message
	
	/* (non-Javadoc)
	 * @see com.berenice.MockitoJUNIT.services.MailService#sendMailMessage(com.berenice.MockitoJUNIT.beans.Message, java.util.List)
	 */
	@Override
	public boolean sendMailMessage(Message m, List <String> emails){
		for (String email : emails){
			
			System.out.println("envoie à" + email +" de "+ m);
		}
		return true;
	}

}
