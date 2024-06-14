package br.com.consoletech.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.consoletech.application.models.User;
import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Transactional
	Optional<User> findByUsername( String username );
	
	@Transactional
	User findByEmail( String email );
}
