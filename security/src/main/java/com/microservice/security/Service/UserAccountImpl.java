package com.microservice.security.Service;

import com.microservice.security.Entity.UserAccount;
import com.microservice.security.Repository.UserAccountRepository;
import com.microservice.security.Dto.PersistUserRequest;
import com.microservice.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountImpl implements  UserAccountService{

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    public UserAccount addUser(PersistUserRequest persistUserRequest){
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(persistUserRequest.getUserName());
        userAccount.setPassword(passwordEncoder.encode(persistUserRequest.getPassword()));
        userAccount.setEmail(persistUserRequest.getEmail());
        userAccount.setRoles(persistUserRequest.getRoles());
        return userAccountRepository.save(userAccount);
    }

    public List<UserAccount> getAllUsers(){
        return userAccountRepository.findAll();
    }

    public Optional<UserAccount> getUser(long id){
        return userAccountRepository.findById(id);
    }

    public String generateToken(String username) {
        return jwtUtil.generateToken(username);
    }
}
