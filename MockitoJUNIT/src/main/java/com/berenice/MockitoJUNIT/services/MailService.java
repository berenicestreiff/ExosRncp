package com.berenice.MockitoJUNIT.services;

import java.util.List;

import com.berenice.MockitoJUNIT.beans.Message;

public interface MailService {

	boolean sendMailMessage(Message m, List<String> emails);

}