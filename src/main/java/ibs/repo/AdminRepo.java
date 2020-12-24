package ibs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ibs.entities.RegistrationEntity;

@Repository
public interface AdminRepo extends JpaRepository<RegistrationEntity, Long>{

	boolean existsByMobileNum(String mobileNum);

	boolean existsByUserName(String userName);

	List<RegistrationEntity> findAllByKycApprovalStatus(String status);


}
