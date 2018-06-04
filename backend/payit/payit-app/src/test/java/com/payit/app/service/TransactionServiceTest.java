package com.payit.app.service;

import com.payit.app.model.Transaction;
import com.payit.app.model.User;
import com.payit.app.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private UserRepository userRepo;

    @Test
    public void createTransaction(){
        User bank= userRepo.findAll().get(0);
        User slave= userRepo.findAll().get(1);
        Float aux= 100f;
        Transaction newTransaction;
        newTransaction=transactionService.createTransaction(bank,slave,aux,null);
        Transaction testTransaction=transactionService.findById(newTransaction.getId());
        assertEquals(testTransaction.getCompleted(),false);
        assertEquals(testTransaction.getBankId(),bank);
        assertEquals(testTransaction.getSlaveId(),slave);
        assertEquals(testTransaction.getValue().compareTo(100f),0);
        assertNull(testTransaction.getEndDate());
    }

    @Test
    public void completeTransaction(){
        User bank= userRepo.findAll().get(0);
        User slave= userRepo.findAll().get(1);
        Float aux=100f;
        Transaction newTransaction;
        newTransaction=transactionService.createTransaction(bank,slave,aux,null);
        transactionService.completeTransaction(newTransaction.getId());
        Transaction testTransaction=transactionService.findById(newTransaction.getId());
        assertEquals(testTransaction.getCompleted(),true);
    }

}
