package com.payit.app.repository;

import com.payit.app.model.Transaction;
import com.payit.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
//    List<Transaction> findByBankId(User bankId);
//    List<Transaction> findBySlaveId(User slaveId);
    List<Transaction> findTransactionByBankId_Id(Integer id);
    List<Transaction> findTransactionBySlaveId_Id(Integer id);
}
