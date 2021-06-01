package com.loiko.alex.authentication;

import com.loiko.alex.exception.LoginException;
import com.loiko.alex.model.UserAccount;
import com.loiko.alex.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@Service
public class UserAccountAuthenticationImpl implements UserAccountAuthentication {

    @Autowired
    private UserAccountRepository repository;

    @Override
    public UserAccount login(String login, String password) {
        try {
            UserAccount account = repository.findUserAccountByUsernameAndPassword(login, password);
            return account;
        } catch (EmptyResultDataAccessException exception) {
            throw new LoginException("Неправильно введён логин или пароль.");
        }
    }
}