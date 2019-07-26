package com.fanmo.thirdpartyplatform.persistence.dao;


import com.fanmo.thirdpartyplatform.persistence.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {

}
