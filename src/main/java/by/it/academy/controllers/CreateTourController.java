package by.it.academy.controllers;

import by.it.academy.entities.Tour;
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

@WebServlet(urlPatterns = "/tour/create", loadOnStartup = 4)
public class CreateTourController extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        Tour tours = new Tour();
        config.getServletContext().setAttribute("Tour", tours);
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name_ofTour = req.getParameter("name_ofTour");
        int cost_ofTour = Integer.parseInt(req.getParameter("cost)ofTour"));
        String state_ofTour = req.getParameter("state_ofTour");
        String hotel = req.getParameter("hotel");
        String attraction = req.getParameter("attraction");
        {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Connection db;
            try {
                db = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Web_tour", "postgres", "sergeychueshov");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            PreparedStatement statement;
            try {
                statement = db.prepareStatement("INSERT into tour(name_ofTour, cost_ofTour, state_ofTour, hotel, attraction) VALUES (?,?,?,?,?)");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            statement.setString(1, name_ofTour);
            statement.setString(2, String.valueOf(cost_ofTour));
            statement.setString(3, state_ofTour);
            statement.setString(4, hotel);
            statement.setString(5, attraction);
            try {
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                db.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

