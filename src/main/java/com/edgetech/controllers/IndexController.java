package com.edgetech.controllers;

import com.edgetech.models.City;
import com.edgetech.models.Country;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    Connection con;

    public IndexController() {
        String url = "jdbc:mysql://localhost:3306/world?useSSL=false"; //	user=root;password=password";
        //  String url = "jdbc:sqlserver://localhost:1433;databaseName=world;";

        try {
            con = DriverManager.getConnection(url, "root", "password");
        } catch (Exception except) {
            System.out.println(except.getMessage());
            SQLException ex = new SQLException("Connection Failed: " + except.getMessage());
        }
    }
    //  http://localhost:8080/districts?district
    //  http://localhost:8080/districts?district=Utah
    @RequestMapping("districts")
    public String index(@RequestParam String district, Model model) throws Exception {

        List<City> cities = new ArrayList<>();
        int population = 0;

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT Name, District, Population, CountryCode FROM City ";
            if (district != null && district.length() > 0)
                query += "WHERE District like '%" + district + "%' ";
            query += "ORDER BY Name";

            ResultSet results = stmt.executeQuery(query);
            //  retrieve all rows from the result set
            while (results.next()) {
                population += results.getInt(3);        //  sum up the population for the cities in the result set
                City city = new City(results.getString("name"), results.getString("district"), results.getInt(3));
                cities.add(city);                       //  this will be our list of cities to save to our web page
            }
        } catch (Exception except) {
            System.out.println(except.getMessage());
            SQLException ex = new SQLException("Query or Connection Failed: " + except.getMessage());
        }
        model.addAttribute("title", "First JDBC Application");
        model.addAttribute("cities", cities);
        model.addAttribute("population", population);
        model.addAttribute("district", district);
        return "cities";
    }
}
