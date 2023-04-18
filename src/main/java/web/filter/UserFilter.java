package web.filter;

import utils.ConfUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/16 9:01
 * #Describe:
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        boolean permission;

        if (null == session.getAttribute("permission")) {
            session.setAttribute("permission", false);
        } else {
            permission = (boolean) session.getAttribute("permission");

            if (permission) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                HttpServletResponse response = (HttpServletResponse)servletResponse;
                String contextPath = request.getContextPath();
                response.sendRedirect(ConfUtils.getCoreConf("URL") + contextPath + "/UserInterface.jsp");
            }
        }
    }

    @Override
    public void destroy() {}
}
