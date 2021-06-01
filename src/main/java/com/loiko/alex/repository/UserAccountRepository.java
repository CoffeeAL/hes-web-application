package com.loiko.alex.repository;

import com.loiko.alex.enumerable.Status;
import com.loiko.alex.model.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    List<UserAccount> findAll();

    Optional<UserAccount> findUserAccountById(Long id);

    Optional<UserAccount> findUserAccountByUsername(String userName);

    List<UserAccount> findUserAccountsByStatus(Status status);

    Status findStatusById(Long id);

    UserAccount findUserAccountByUsernameAndPassword(String username, String password);
}