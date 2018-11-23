package com.kingbin.component;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WangBin on 2018/10/24
 * <p>
 * 跨域过滤器
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "authFilter")
public class CorsFilter implements Filter {

    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);
    /**
     * 封装，不需要过滤的list列表
     */
    private static List<Pattern> patterns = new ArrayList<Pattern>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------------初始化过滤器------------");
        patterns.add(Pattern.compile("/login/loginByName"));
        patterns.add(Pattern.compile("/login/isUpdate"));
        patterns.add(Pattern.compile("/traceability/findTraceabilityByAll"));
        patterns.add(Pattern.compile("/traceability/findTraceabilityByEquId"));
        patterns.add(Pattern.compile("/resource/findResourceByAll"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        httpResponse.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept,x-requested-with");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        System.out.println("------------前往------------");
        logger.info(httpRequest.getRequestURI());
        logger.info(httpRequest.getContextPath());
        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//        if (url.startsWith("/") && url.length() > 1) {
//            url = url.substring(1);
//        }
        if (isInclude(url)) {
            filterChain.doFilter(httpRequest, httpResponse);
        } else {
            HttpSession session = httpRequest.getSession();
            if (session != null && session.getAttribute("user") != null) {
                // session存在
                filterChain.doFilter(httpRequest, httpResponse);
            } else {
                // session不存在 准备跳转失败
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/login/loginByName");
                dispatcher.forward(servletRequest, httpResponse);
//                httpResponse.sendRedirect("http://192.168.16.189:8080/login/login");
                return;
            }
            filterChain.doFilter(httpRequest, httpResponse);
        }
        System.out.println("------------返回------------");
    }

    @Override
    public void destroy() {
        System.out.println("------------销毁过滤器------------");
    }

    /**
     * 是否需要过滤
     *
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

}
