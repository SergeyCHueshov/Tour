package by.it.academy.controllers;

import by.it.academy.entities.User;
import lombok.SneakyThrows;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/user/authorization", loadOnStartup = 0)
public class AuthorizationUserController extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        User users = new User();
        config.getServletContext().setAttribute("User", users);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String userType = req.getParameter("userType");
        {
            try {
                Class.forName("org.postgresql.Driver");
            Connection db;
            db = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Web_tour", "postgres", "sergeychueshov");
            PreparedStatement statement;
            statement = db.prepareStatement("INSERT into user_authorization(login, password, userType) VALUES (?,?,?)");
            statement.setString(1, login);
            statement.setString(2, password);
            statement.setString(3, userType);
            statement.executeUpdate();
            statement.close();
            db.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        req.getRequestDispatcher("/pages/creation.jps");
    }
}
