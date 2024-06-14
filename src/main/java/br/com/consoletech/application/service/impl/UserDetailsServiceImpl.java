package br.com.consoletech.application.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.consoletech.application.models.UserAuthenticated;
import br.com.consoletech.application.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository repo;

	public UserDetailsServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findByUsername(username).map(user -> new UserAuthenticated(user))
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
	}

}
