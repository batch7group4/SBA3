package ibs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibs.entities.LoginDetailsEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetailsEntity, Long>{

	boolean existsByUserName(String role);

	LoginDetailsEntity findByUserName(String userName);

}
