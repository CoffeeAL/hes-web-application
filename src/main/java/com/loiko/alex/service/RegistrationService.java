package com.loiko.alex.service;

import com.loiko.alex.model.UserAccount;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
public interface RegistrationService {

    boolean isLoginIn();

    UserAccount save(UserAccount account);
}