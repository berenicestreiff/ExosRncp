package com.berenice.MockitoJUNIT.services;

import com.berenice.MockitoJUNIT.beans.Message;
import com.berenice.MockitoJUNIT.beans.Template;

public class TemplateServiceImpl implements TemplateService {

	
	/* (non-Javadoc)
	 * @see com.berenice.MockitoJUNIT.services.TemplateService#format(com.berenice.MockitoJUNIT.beans.Template, com.berenice.MockitoJUNIT.beans.Message)
	 */
	@Override
	public Message format(Template t,Message m){
		return new Message(m.getTitre().replaceAll(t.getToReplace(), t.getReplacement()),
				          m.getCorps().replaceAll(t.getToReplace(), t.getReplacement())
				          );
	};
}

