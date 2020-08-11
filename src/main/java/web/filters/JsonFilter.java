package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "JsonFilter", urlPatterns = "/ff")
public class JsonFilter implements Filter {
    public void destroy() { }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(req.getContentType() == null || req.getContentType().equals("application/json") ){
            chain.doFilter(req, resp);
        }
        else{
            ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_BAD_REQUEST, "not json");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
