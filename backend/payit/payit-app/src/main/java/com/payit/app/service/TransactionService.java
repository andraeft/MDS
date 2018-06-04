package com.payit.app.service;

import com.payit.app.model.Transaction;
import com.payit.app.model.User;
import com.payit.app.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repo;

    public Transaction createTransaction(User bankId, User slaveId, Float value, Date endDate){
        Transaction newTransaction= new Transaction();
        newTransaction.setBankId(bankId);
        newTransaction.setSlaveId(slaveId);
        newTransaction.setValue(value);
        newTransaction.setEndDate(endDate);
        return repo.save(newTransaction);
    }

    @Transactional
    public void completeTransaction(Integer id){
        Transaction completedTransaction=repo.findById(id).orElse(null);
        if(completedTransaction==null)
            return;
        completedTransaction.setCompleted(true);
    }

    public Transaction findById(Integer id){
        return repo.findById(id).orElse(null);
    }

    public Collection<Transaction> searchByBank(Integer id) {
        return repo.findTransactionByBankId_Id(id);
    }

    public Collection<Transaction> searchBySlave(Integer id) {
        return repo.findTransactionBySlaveId_Id(id);
    }

}

