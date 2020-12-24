package ibs.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibs.entities.BenficiaryEntity;



@Repository
public interface CustomerBenRepo extends JpaRepository<BenficiaryEntity, Long>{

	List<BenficiaryEntity> findByCustAcctNum(long custAcctNum);

}
