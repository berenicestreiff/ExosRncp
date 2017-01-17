package com.berenice.bloSecureBereV2.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.berenice.bloSecureBereV2.metier.Message;

public interface MessageRepository 
		extends PagingAndSortingRepository<Message, Integer> {

	Page<Message> findByTitreContaining(String titre, Pageable p);
	
	List <Message>findByPublished(boolean published);
	public List<Message> findByTitreContainingAndPublished(String titre, boolean published);


}