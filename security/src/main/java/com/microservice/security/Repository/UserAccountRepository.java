package com.microservice.security.Repository;

import com.microservice.security.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {

    Optional<UserAccount> findByUserName(String username);
}
