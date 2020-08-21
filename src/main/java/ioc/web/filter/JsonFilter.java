package ioc.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "JsonFilter", urlPatterns = "/*")
public class JsonFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (((HttpServletRequest) req).getMethod().equals("GET")){
            chain.doFilter(req, resp);
        }else if(req.getContentLength() != 0 && req.getContentType().equals("application/json")){
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_BAD_REQUEST, "not json");
        }
    }

    public void init(FilterConfig config){
    }
}
