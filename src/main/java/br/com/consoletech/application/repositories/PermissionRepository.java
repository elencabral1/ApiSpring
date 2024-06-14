package br.com.consoletech.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.consoletech.application.models.Permission;
import jakarta.transaction.Transactional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
	
	@Transactional
	Optional<Permission> findByName( String name );
}
