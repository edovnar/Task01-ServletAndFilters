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
@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String name = ((HttpServletRequest) req).getHeader("name");
        String password = ((HttpServletRequest) req).getHeader("password");

        User currentUser = new User(name, password);

        try {
            if(UserService.getUser(currentUser) != null){
                UserContext.setCurrentUser(currentUser);

                chain.doFilter(req, resp);
            }
            else{
                ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_BAD_REQUEST, "lol no");
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() { }
}
