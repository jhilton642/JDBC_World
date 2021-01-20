package com.edgetech.models;

public class Country {
    String name;
    String continent;
    int population;
    int lifeExpectancy;
    String capital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Country(String name, String continent, int population, int lifeExpectancy, String capital) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.capital = capital;
    }

    public Country() {
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", LifeExpectancy=" + lifeExpectancy +
                ", capital='" + capital + '\'' +
                '}';
    }
}
