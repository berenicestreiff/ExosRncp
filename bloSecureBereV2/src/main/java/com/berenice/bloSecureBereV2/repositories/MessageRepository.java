package com.berenice.bloSecureBereV2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.berenice.bloSecureBereV2.metier.Message;

public interface MessageRepository 
		extends PagingAndSortingRepository<Message, Integer> {

	Page<Message> findByTitreContaining(String titre, Pageable p);
}


