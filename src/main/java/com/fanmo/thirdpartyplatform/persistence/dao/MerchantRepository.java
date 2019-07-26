package com.fanmo.thirdpartyplatform.persistence.dao;

import com.fanmo.thirdpartyplatform.persistence.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
	
	Merchant findByName(String name);
	Merchant findById(Long id);
}
