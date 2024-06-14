package br.com.consoletech.application.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.consoletech.application.models.Group;
import br.com.consoletech.application.models.Permission;
import br.com.consoletech.application.repositories.GroupRepository;
import br.com.consoletech.application.repositories.PermissionRepository;


public class GroupSeeder implements CommandLineRunner {
	
	@Autowired
	private final GroupRepository groupRepository;
	
	@Autowired
	private final PermissionRepository permissionRepository;
	
	
	public GroupSeeder(GroupRepository groupRepository, PermissionRepository permissionRepository) {
		this.groupRepository = groupRepository;
		this.permissionRepository = permissionRepository;
	}

	@Override
	public void run(String... args) throws Exception {
        List<Permission> permissions = permissionRepository.findAllById(List.of(1L, 2L, 3L, 4L));

        Group g1 = new Group(null, "administradores", "grupo de administradores do sistema", false, permissions);
        
        groupRepository.save(g1);
		
	}

}
