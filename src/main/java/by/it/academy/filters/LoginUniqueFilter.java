package by.it.academy.filters;

import by.it.academy.entities.User;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@WebFilter(urlPatterns = {"/user/authorization"})
public class LoginUniqueFilter extends HttpFilter {
    private static final long serialVersionUID = 5992383555475358650L;
    private static final String USERS_URL = "/user/create";
    private User users;
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        config.getServletContext().getAttribute("DBConnector");
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String login = req.getParameter("login");
        User users = new User();
        Optional<User> userOptional = Stream.of(users)
                .filter(user -> user.getLogin().equals(req.getParameter("login")))
                .findFirst();
        if (userOptional.isPresent()) {
            req.getRequestDispatcher("/pages/errors/loginmistake.jsp").forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}
