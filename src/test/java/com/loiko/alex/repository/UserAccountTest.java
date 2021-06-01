package com.loiko.alex.repository;

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

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@SpringBootTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                scripts = {"classpath:schema.sql", "classpath:data.sql"})})
public class UserAccountTest {

    @Autowired
    private UserAccountRepository account;

    @Test
    public void findAllAccounts() {
        List<UserAccount> allAccounts = account.findAll();
        assertTrue(allAccounts.size() == 5);
    }

    @Test
    public void findAccountById() {
        Long presentId = 2L;
        Optional<UserAccount> presentAccount = account.findById(presentId);
        assertTrue(presentAccount.isPresent());
    }

    @Test
    public void makeSureAccountIsAbsent() {
        Long absentId = 6L;
        Optional<UserAccount> absentAccount = account.findById(absentId);
        assertTrue(absentAccount.isEmpty());
    }

    @Test
    public void saveAccount() {
        UserAccount mika = new UserAccount("Mika", "Mika", "Mika", "Hakkinen",
                                           Role.USER, Status.ACTIVE);
        account.save(mika);
        assertTrue(mika.getId() != null);
    }

    @Test
    public void deleteAccountById() {
        Long id = 1L;
        account.deleteById(id);
        Optional<UserAccount> removedUser = account.findById(id);
        assertTrue(removedUser.isEmpty());
    }

   // @Test
//    public void deleteAllAccounts() {
//        account.deleteAll();
//    }
}