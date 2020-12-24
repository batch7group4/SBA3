package ibs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibs.entities.CustAcctEntity;



@Repository
public interface CustomerRepo extends JpaRepository<CustAcctEntity, Long>{


	List<CustAcctEntity> findByRegId(long regId);

	List<CustAcctEntity> findByUserName(String userName);

	List<CustAcctEntity> findByCustAcctType(String custAcctType);

	List<CustAcctEntity> findByCustAcctNum(long fromAcctNum);


}
