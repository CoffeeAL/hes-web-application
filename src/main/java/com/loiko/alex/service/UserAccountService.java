package com.loiko.alex.service;

import com.loiko.alex.enumerable.Status;
import com.loiko.alex.model.UserAccount;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
public interface UserAccountService {

    List<UserAccount> findAllAccounts();

    boolean saveAccount(UserAccount account);

    void deleteAccountById(Long id);

    Optional<UserAccount> findAccountById(Long id);

    List<UserAccount> findUserAccountsByStatus(Status status);

    Status findStatusByUserId(Long id);

    UserAccount findAccountByUsernameAndPassword(String username, String password);

    Optional<UserAccount> findUserAccountByUsername(String username);
}