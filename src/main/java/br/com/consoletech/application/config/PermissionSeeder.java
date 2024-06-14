package br.com.consoletech.application.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.consoletech.application.models.Permission;
import br.com.consoletech.application.repositories.PermissionRepository;

@Configuration
public class PermissionSeeder implements CommandLineRunner {
	
	@Autowired
	private final PermissionRepository permissionRepository;
	
	public PermissionSeeder(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> permissionNames = Arrays.asList("USERS_SELECT", "USERS_INSERT", "USERS_UPDATE", "USERS_DELETE");
		
		for (String name : permissionNames) {
			Optional<Permission> existingPermission = permissionRepository.findByName(name);
			if (existingPermission.isEmpty()) {
				Permission permission = new Permission(null, name);
				permissionRepository.save(permission);
			}
		}
	}
}
