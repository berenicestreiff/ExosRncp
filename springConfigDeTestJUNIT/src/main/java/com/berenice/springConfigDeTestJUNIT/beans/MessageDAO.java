package com.berenice.springConfigDeTestJUNIT.beans;

import java.util.List;

public interface MessageDAO {

	List<Message> findAll();

	Message findById(int id);

	int save(Message m);

}