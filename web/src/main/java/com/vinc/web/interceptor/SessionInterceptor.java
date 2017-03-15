package com.vinc.web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
//        if (WebUtils.getCookie(request, Constants.COOKIE_ACCOUNT_KEY) == null) {
//            ServletOutputStream out = response.getOutputStream();
//            IOUtils.write(JSON.toJSONString(new ResponseVo(ResponseVo.ErrorCode.SESSION_EXPIRED)), out, Constants.DEFAULT_CHARSET);
//            response.setContentType(ContentType.APPLICATION_JSON.withCharset(Constants.DEFAULT_CHARSET).toString());
//            try {
//                out.flush();
//            } finally {
//                IOUtils.closeQuietly(out);
//            }
//            return false;
//        } else {
//            TokenContextHolder.setLoginAccountId(WebUtils.getCookie(request, Constants.COOKIE_ACCOUNT_KEY).getValue());
            return true;
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
//        TokenContextHolder.clearLoginAccountId();
    }

}