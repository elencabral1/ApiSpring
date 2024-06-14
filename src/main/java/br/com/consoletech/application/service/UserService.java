package br.com.consoletech.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.consoletech.application.models.User;

@Service
public interface UserService {
	
	List<User> findAll();
	User findById( Long id );
	User findByEmail( String email );
	User insert( User obj );
	User update( User obj );
	void delete( Long id );


}
