package com.fanmo.thirdpartyplatform.persistence.dao;

import com.fanmo.thirdpartyplatform.persistence.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByUsername(String username);
	Account findByUsernameAndPassword(String username, String password);
}
