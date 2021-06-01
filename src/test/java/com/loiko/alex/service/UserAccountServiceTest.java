package com.loiko.alex.service;

import com.loiko.alex.enumerable.Role;
import com.loiko.alex.enumerable.Status;
import com.loiko.alex.model.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@SpringBootTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                scripts = {"classpath:schema.sql", "classpath:data.sql"})})
public class UserAccountServiceTest {

    @Autowired
    private UserAccountService service;

    @Test
    public void findAllAccounts() {
        List<UserAccount> allAccounts = service.findAllAccounts();
        assertTrue(allAccounts.size() == 5);
    }

    @Test
    public void findExistedAccountById() {
        Long presentId = 1L;
        Optional<UserAccount> presentAccount = service.findAccountById(presentId);
        assertTrue(presentAccount.isPresent());
    }

    @Test
    public void makeSureNotExistedAccount() {
        Long absentId = 6L;
        Optional<UserAccount> absentAccount = service.findAccountById(absentId);
        assertTrue(absentAccount.isEmpty());
    }

//    @Test
//    public void saveAccount() {
//        UserAccount newAccount = new UserAccount("Niki", "nlauda", "Niki",
//                                       "Lauda", Role.USER, Status.ACTIVE);
//        UserAccount savedAccount = service.saveAccount(newAccount);
//        assertNotNull(savedAccount);
//    }

    @Test
    public void deleteAccount() {
        Long idForDelete = 4L;
        List<UserAccount> allAccountsBeforeDelete = service.findAllAccounts();
        assertTrue(allAccountsBeforeDelete.size() == 5);
        service.deleteAccountById(idForDelete);
        List<UserAccount> allAccountAfterDelete = service.findAllAccounts();
        assertTrue(allAccountAfterDelete.size() == 4);
    }
}