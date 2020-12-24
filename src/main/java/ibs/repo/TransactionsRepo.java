package ibs.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibs.entities.AcctTransactionEntity;


@Repository
public interface TransactionsRepo extends JpaRepository<AcctTransactionEntity, Long>{

	List<AcctTransactionEntity> findByCustAcctNum(long custAcctNum);


}
