package br.com.consoletech.application.service.impl;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.consoletech.application.models.User;
import br.com.consoletech.application.repositories.UserRepository;
import br.com.consoletech.application.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
	}
	
	@Override
	public User insert(User obj) {
		if (obj.getId() != null) {
			throw new IllegalArgumentException("New user cannot have an ID");
		}
		obj.setCreated( Instant.now() );
		obj.setUpdated( Instant.now() );
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		return userRepository.save(obj);
	}
	
	@Override
	public User update(User obj) {
		if (obj.getId() == null) {
			throw new IllegalArgumentException("User ID cannot be null for update");
		}
		if (!userRepository.existsById(obj.getId())) {
			throw new IllegalArgumentException("User not found with id: " + obj.getId());
		}
		obj.setUpdated( Instant.now() );
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		return userRepository.save(obj);
	}
	
	@Override
	public void delete(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
		userRepository.delete(user);
	}
	
	@Override
	public User findByEmail( String email ) {
		return  userRepository.findByEmail(email);
	}
}
