package com.edgetech.controllers;

import com.edgetech.models.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmController {
    Connection con;

    public FilmController() {
        String url = "jdbc:mysql://localhost:3306/sakila?useSSL=false"; //	user=root;password=password";
        // String url = "jdbc:sqlserver://localhost:1433;databaseName=world;";

        try {
            con = DriverManager.getConnection(url, "sa", "password");
        } catch (Exception except) {
            System.out.println(except.getMessage());
            SQLException ex = new SQLException("Connection Failed: " + except.getMessage());
        }
    }
    @RequestMapping("film")
    public String movie(Model model) throws Exception {
        List<Film> films = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT Title,Release_Year as 'releaseYear',Length,Rating,Rental_Rate as 'rentalRate'FROM Film";


            ResultSet results = stmt.executeQuery(query);
            //  retrieve all rows from the result set
            while (results.next()) {

                Film film = new Film(results.getString("title"), results.getInt("releaseYear"), results.getInt("length"), results.getString("rating"), results.getDouble("rentalRate"));
                films.add(film);                       //  this will be our list of cities to save to our web page
            }
        } catch (Exception except) {
            System.out.println(except.getMessage());
            SQLException ex = new SQLException("Query or Connection Failed: " + except.getMessage());
        }
        model.addAttribute("title", "First JDBC Application");
        model.addAttribute("joshua", films);
        return "film";
    }
}