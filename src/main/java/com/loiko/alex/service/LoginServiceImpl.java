package com.loiko.alex.service;

import com.loiko.alex.converter.ConverterImpl;
import com.loiko.alex.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginServiceImpl implements LoginService {

    private final UserAccountRepository account;
    private final ConverterImpl converter;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return account
                .findUserAccountByUsername(userName)
                .map(converter::convert)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}