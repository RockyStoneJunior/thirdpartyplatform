package com.fanmo.thirdpartyplatform.persistence.dao;


import com.fanmo.thirdpartyplatform.persistence.model.AppId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppIdRepository extends JpaRepository<AppId, Long> {
    AppId findByPlatformAppid(String appid);
    List<AppId> findByPlatformName(String platform_name);
    AppId findByUsername(String username);
    AppId findByUsernameAndPassword(String username, String password);

    List<AppId> findAllByBUsername(String b_username);
    List<AppId> findAllByPlatformNameOrMiniproNameOrUsername(String platform_name, String minipro_name, String merchant_no);
    AppId findByIdAndBUsername(Long id, String b_username);
    AppId findById(Long id);
}
