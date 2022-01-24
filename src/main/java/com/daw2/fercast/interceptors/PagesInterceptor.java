package com.daw2.fercast.interceptors;

import com.daw2.fercast.model.entity.LogPage;
import com.daw2.fercast.pojo.LogCode;
import com.daw2.fercast.service.LogPagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PagesInterceptor implements HandlerInterceptor {
    private static final Logger logger =  LoggerFactory.getLogger(PagesInterceptor.class);

    @Autowired

    private LogPagesService logPagesService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //logger.info("preHandle");
        logger.info("Acceso a URL: " + request.getRequestURI());
        logger.info("Origen de la peticion:" + request.getRemoteAddr());
        if (handler instanceof HandlerMethod) {
            logger.info("Acceso a método:" + request.getMethod());
            creaLog(LogCode.PAGE_LOADING,request,handler);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //logger.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //logger.info("afterCompletion");
        if (handler instanceof HandlerMethod) {
            HandlerMethod metodo = (HandlerMethod) handler;
            logger.info("Acceso a (" + request.getMethod() + ") "
            + request.getRequestURI() + "   -   Método: "
            + metodo.getMethod().getName());
            creaLog(LogCode.PAGE_LOADING,request,handler);
        }
    }
    private void creaLog(String codigo, HttpServletRequest request, Object handler){
        LogPage log = new LogPage();
        log.setCodOperation(codigo);
        log.setDescripcion("Método:"+request.getMethod());
        log.setIp(request.getRemoteAddr());
        log.setPage(request.getRequestURI());
        logPagesService.save(log);
    }

}
