package sa47.team12.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sa47.team12.model.Administrator;

public interface AdministratorRepo extends JpaRepository<Administrator, Integer> {
	

}