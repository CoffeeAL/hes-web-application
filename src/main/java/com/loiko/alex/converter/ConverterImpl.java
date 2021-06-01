package com.loiko.alex.converter;

import com.loiko.alex.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@Component
public class ConverterImpl implements Converter<UserAccount, UserDetails> {

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails convert(UserAccount account) {
        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .password(passwordEncoder.encode(account.getPassword()))
                .authorities(account.getRole().toString())
                .build();
    }
}