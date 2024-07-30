package party.msdg.work.base.auth;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import party.msdg.work.base.work.WorkCode;
import party.msdg.work.toolkit.LittleTrick;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class AuthorizedRequestInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizedRequestInterceptor.class);

    public AuthorizedRequestInterceptor() {
        logger.info("============**********************************************************************================");
        logger.info("============  启用对网关路由过来的请求的登录检查");
        logger.info("============***********************************************************************================");
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DispatcherType dispatchType = request.getDispatcherType();
        if (DispatcherType.REQUEST == dispatchType || DispatcherType.ASYNC == dispatchType) {
            
            if (handler instanceof HandlerMethod) {
                if (! StpUtil.isLogin()) {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType("application/json;charset=UTF-8");
                    String message = makeErrMsg(request.getRequestURI(), WorkCode.UNLOGIN);
                    response.getOutputStream().write(message.getBytes(StandardCharsets.UTF_8));
                    response.getOutputStream().flush();
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private String makeErrMsg(String path, WorkCode err) {
        return "{" +
            "\"code\":" + err.code() + "," +
            "\"message\":\"" + err.text() + "\", " +
            "\"path\":\"" + path + "\"," +
            "\"timestamp\":" + new Date().getTime() +
            "}";
    }
}