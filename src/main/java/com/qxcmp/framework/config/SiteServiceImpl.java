package com.qxcmp.framework.config;

import com.qxcmp.framework.core.QXCMPSystemConfigConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiteServiceImpl implements SiteService {

    private final SystemConfigService systemConfigService;

    /**
     * 平台默认名称
     * <p>
     * 配置在 Spring Boot application.yml 文件里面
     */
    @Value("${application.name}")
    private String applicationName;

    @Override
    public String getTitle() {
        return systemConfigService.getString(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_SITE_TITLE).orElse(applicationName);
    }

    @Override
    public String getDomain() {
        return systemConfigService.getString(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_SITE_DOMAIN).orElse("");
    }

    @Override
    public String getLogo() {
        return systemConfigService.getString(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_SITE_LOGO).orElse(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_SITE_LOGO_DEFAULT_VALUE);
    }

    @Override
    public String getFavicon() {
        return systemConfigService.getString(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_SITE_FAVICON).orElse(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_SITE_FAVICON_DEFAULT_VALUE);
    }

    @Override
    public String getKeywords() {
        return systemConfigService.getString(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_SITE_KEYWORDS).orElse("");
    }

    @Override
    public String getDescription() {
        return systemConfigService.getString(QXCMPSystemConfigConfiguration.SYSTEM_CONFIG_SITE_DESCRIPTION).orElse("");
    }
}
