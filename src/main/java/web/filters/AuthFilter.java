package web.filters;

import domain.User;
import exception.UserNotFoundException;
import service.UserService;
import utils.UserContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String authHeader = req.getHeader("Authorization");

        if(authHeader != null){
            StringTokenizer st = new StringTokenizer(authHeader);

            if(st.hasMoreTokens()){
                String basic = st.nextToken();

                if(basic.equalsIgnoreCase("Basic")){
                    try{
                        String userInfo = new String(Base64.getDecoder().decode(st.nextToken()));
                        int p = userInfo.indexOf(":");
                        if(p != -1){
                            String name = userInfo.substring(0, p).trim();
                            String password = userInfo.substring(p + 1).trim();

                            User currentUser = new User(name, password);
                            UserContext.setCurrentUser(UserService.getUser(currentUser));
                            chain.doFilter(request, response);
                        }
                    } catch (UserNotFoundException e) {
                        ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    }
                }
            }
        }
    }

    @Override
    public void destroy() { }
}
