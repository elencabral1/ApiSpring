package br.com.consoletech.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.consoletech.application.models.Group;
import jakarta.transaction.Transactional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
	
	@Transactional
	Optional<Group> findByName( String name );
}
