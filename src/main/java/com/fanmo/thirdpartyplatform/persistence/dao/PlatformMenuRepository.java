package com.fanmo.thirdpartyplatform.persistence.dao;

import com.fanmo.thirdpartyplatform.persistence.model.PlatformMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformMenuRepository extends JpaRepository<PlatformMenu, Long> {
    PlatformMenu findByPlatformName(String platform_name);
    PlatformMenu findByPlatformNameAndBUsername(String platform_name, String b_username);
}
