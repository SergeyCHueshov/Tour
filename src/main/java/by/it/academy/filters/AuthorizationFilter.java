package by.it.academy.filters;

import by.it.academy.entities.UserType;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user/authorization"})
public class AuthorizationFilter extends HttpFilter {
    private static final long serialVersionUID = 5992383557775358650L;
    private static final String USAGE_URI = "/pages/creation.jsp";
    private static final String USAGE_URL = "/pages/admin/admin.jps";
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        if (null != session && null != session.getAttribute("userType")) {
            UserType userType = (UserType) session.getAttribute("userType");
            if (userType == UserType.ADMIN) {
                req.getRequestDispatcher(USAGE_URL).forward(req, res);
            } else if (userType == UserType.USER) {
                req.getRequestDispatcher(USAGE_URI).forward(req, res);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        config.getServletContext().getAttribute("DBConnector");
    }

    @Override
    public void destroy() {

    }
}
