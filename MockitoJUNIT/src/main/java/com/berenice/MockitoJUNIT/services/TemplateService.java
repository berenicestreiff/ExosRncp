package com.berenice.MockitoJUNIT.services;

import com.berenice.MockitoJUNIT.beans.Message;
import com.berenice.MockitoJUNIT.beans.Template;

public interface TemplateService {

	Message format(Template t, Message m);

}