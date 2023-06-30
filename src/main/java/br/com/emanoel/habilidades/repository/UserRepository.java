package br.com.emanoel.habilidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emanoel.habilidades.models.Users;
import io.swagger.v3.oas.annotations.Parameter;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query("SELECT u FROM users where u.userName =:userName ")
	Users findByUsername(@Param("username") String userName);
}
