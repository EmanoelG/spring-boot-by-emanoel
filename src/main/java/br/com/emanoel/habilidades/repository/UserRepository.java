package br.com.emanoel.habilidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emanoel.habilidades.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query(value = "SELECT * FROM Users u WHERE u.user_name = :userName", nativeQuery = true)
	Users findByUsername(@Param("userName") String userName);
}
