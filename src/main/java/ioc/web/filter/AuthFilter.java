package ioc.web.filter;

import ioc.exception.UserNotFoundException;
import ioc.service.UserService;
import ioc.utils.AppContext;
import ioc.utils.UserContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Base64;

//@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig){ }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String authHeader = req.getHeader("Authorization");

        if(authHeader != null){
            String[] str = authHeader.split(" ");
            if(str[0].equals("Basic")){
                try{
                    String decodeInfo = new String(Base64.getDecoder().decode(str[1]));
                    String[] userInfo = decodeInfo.split(":");

                    String name = userInfo[0];
                    String password = userInfo[1];

                    UserService userService = AppContext.getContext().getBean(UserService.class);

                    if (userService.getUser(name).getPassword().equals(password)){
                        UserContext.setCurrentUser(userService.getUser(name));
                        chain.doFilter(request, response);
                    }
                } catch (UserNotFoundException e) {
                    ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
                }
            }
        }
    }

    @Override
    public void destroy() { }
}
