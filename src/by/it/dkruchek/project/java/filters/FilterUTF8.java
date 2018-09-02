package by.it.dkruchek.project.java.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", initParams = {@WebInitParam(name = "encode", value = "UTF-8")})
public class FilterUTF8 implements Filter {

    private String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String encoding = servletRequest.getCharacterEncoding();
        if (encoding == null || !encoding.equals(encode)){
            servletRequest.setCharacterEncoding(encode);
        }
        encoding = servletResponse.getCharacterEncoding();
        if (encoding == null || !encoding.equals(encode)){
            servletResponse.setCharacterEncoding(encode);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
