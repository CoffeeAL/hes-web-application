package com.loiko.alex.service;

import com.loiko.alex.model.UserAccount;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public boolean isLoginIn() {
        return false;
    }

    @Override
    public UserAccount save(UserAccount account) {
        return null;
    }
}