package br.com.consoletech.application.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.consoletech.application.models.User;
import br.com.consoletech.application.service.UserService;

@Configuration
public class UserAdminSeeder implements CommandLineRunner {
	
	private final UserService service;
	

	public UserAdminSeeder(UserService service ) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = service.findByEmail( "console.tech@outlook.com");
				
		
		if( user == null ) {
			System.out.println("User not found");
			user = new User( null, "leonardo", "console.tech@outlook.com", true, "040358", null, null );
			System.out.println( service.insert(user) );
		}else {
			System.out.println( "User admin exists!" );
			
		}
		
	}

}
