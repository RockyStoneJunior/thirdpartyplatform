package com.fanmo.thirdpartyplatform.persistence.dao;

import com.fanmo.thirdpartyplatform.persistence.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
	Branch findByMerchantIdAndName(Long merchant_id, String name);
	Branch findById(Long id);
	Branch findByNameEn(String name_en);
}
