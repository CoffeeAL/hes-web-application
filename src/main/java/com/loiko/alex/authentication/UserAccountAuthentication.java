package com.loiko.alex.authentication;

import com.loiko.alex.model.UserAccount;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
public interface UserAccountAuthentication {

    UserAccount login(String login, String password);
}