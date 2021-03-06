package com.qxcmp.framework.web.support;

import com.qxcmp.framework.web.page.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.qxcmp.framework.core.QXCMPConfiguration.*;

/**
 * 平台页面解析器
 * <p>
 * 负责根据请求把页面解析为对应的页面实体
 * <p>
 * <ol> <li>后台页面</li> <li>账户注册页面</li> <li>前端大屏页面</li> <li>前端平板页面</li> <li>前端移动页面</li> </ol>
 *
 * @author Aaric
 */
@Component
@RequiredArgsConstructor
public class QXCMPPageResolver {

    private final ApplicationContext applicationContext;

    private final QXCMPDeviceResolver deviceResolver;

    /**
     * 把请求解析为一个页面
     *
     * @param request 请求
     * @return 解析后的页面
     */
    public AbstractPage resolve(HttpServletRequest request, HttpServletResponse response) {
        return resolveByPath(request.getRequestURI(), request, response);
    }

    public AbstractPage resolveByPath(String path, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.startsWith(path, QXCMP_BACKEND_URL)) {
            return applicationContext.getBean(BackendPage.class, request, response);
        } else if (StringUtils.startsWith(path, QXCMP_ACCOUNT_URL) || StringUtils.startsWith(path, QXCMP_LOGIN_URL) || StringUtils.startsWith(path, QXCMP_LOGOUT_URL)) {
            return applicationContext.getBean(NormalPage.class, request, response);
        } else {
            Device device = deviceResolver.resolve(request);

            if (device.isMobile()) {
                return applicationContext.getBean(MobilePage.class, request, response);
            } else if (device.isTablet()) {
                return applicationContext.getBean(TabletPage.class, request, response);
            } else {
                return applicationContext.getBean(NormalPage.class, request, response);
            }
        }
    }
}
