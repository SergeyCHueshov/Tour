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

@WebServlet(urlPatterns = "/user/create", loadOnStartup = 2)
public class CreateUserController extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));

        try {
            Class.forName("org.postgresql.Driver");
            Connection db;
            db = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Web_tour", "postgres", "sergeychueshov");
            PreparedStatement statement;
            statement = db.prepareStatement("INSERT into person_user(name, surname, age) VALUES (?,?,?)");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, String.valueOf(age));
            statement.executeUpdate();
            statement.close();
            db.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("/tour/read");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        User users = (User) config.getServletContext().getAttribute("User");
    }
}

