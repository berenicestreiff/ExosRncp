package com.courtalon.BoutiqueServiceForm.repositories;

import java.util.List;

import com.courtalon.BoutiqueServiceForm.metier.Message;

public interface MessageDAO {

	List<Message> findAll();

	Message findById(int id);

	int save(Message m);

}
