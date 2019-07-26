package com.fanmo.thirdpartyplatform.persistence.dao;


import com.fanmo.thirdpartyplatform.persistence.model.OnlineUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OnlineUserRepository extends JpaRepository<OnlineUser, Long> {
	OnlineUser findByBranchId(Long branch_id);
	
	List<OnlineUser> findByUsername(String username);
}
