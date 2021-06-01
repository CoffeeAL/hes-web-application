package com.loiko.alex.service;

import com.loiko.alex.enumerable.Status;
import com.loiko.alex.model.UserAccount;
import com.loiko.alex.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserAccount> findAllAccounts() {
        return repository.findAll();
    }

    @Override
    public boolean saveAccount(UserAccount account) {
        Optional<UserAccount> userAccount = repository.findUserAccountByUsername(account.getUsername());
        if (userAccount.isPresent()) {
            return false;
        }
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        repository.save(account);
        return true;
    }

    @Override
    public void deleteAccountById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserAccount> findAccountById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserAccount> findUserAccountsByStatus(Status status) {
        return repository.findUserAccountsByStatus(status);
    }

    @Override
    public Status findStatusByUserId(Long id) {
        return repository.findStatusById(id);
    }

    @Override
    public UserAccount findAccountByUsernameAndPassword(String username, String password) {
        return repository.findUserAccountByUsernameAndPassword(username, password);
    }

    @Override
    public Optional<UserAccount> findUserAccountByUsername(String username) {
        return repository.findUserAccountByUsername(username);
    }
}