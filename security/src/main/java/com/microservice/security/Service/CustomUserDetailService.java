package com.microservice.security.Service;

import com.microservice.security.Entity.UserAccount;
import com.microservice.security.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService  {

    @Autowired
    private UserAccountRepository userAccountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> user = userAccountRepository.findByUserName(username);

        return user.map(GrantRole::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " Not Found"));
    }
}
