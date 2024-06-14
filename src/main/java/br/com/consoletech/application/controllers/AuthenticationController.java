package br.com.consoletech.application.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.consoletech.application.service.AuthenticationService;

@RestController
public class AuthenticationController {
	
	private final AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@PostMapping("authenticate")
	public String authenticate( Authentication authentication) {
		return authenticationService.authenticate( authentication );
	}
	
}
