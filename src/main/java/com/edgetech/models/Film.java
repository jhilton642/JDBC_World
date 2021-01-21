package com.edgetech.models;

public class Film {
        String title;
        int releaseYear;
        int length;
        String rating;
        double rentalRate;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public double getRentalRate() {
            return rentalRate;
        }

        public void setRentalRate(double rentalRate) {
            this.rentalRate = rentalRate;
        }

    public Film(String title, int releaseYear, int length, String rating, double rentalRate) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.length = length;
        this.rating = rating;
        this.rentalRate = rentalRate;
    }

    public Film() {
    }

    @Override
        public String toString() {
            return "FilmController{" +
                    "title='" + title + '\'' +
                    ", releaseYear=" + releaseYear +
                    ", length=" + length +
                    ", rating='" + rating + '\'' +
                    ", rentalRate=" + rentalRate +
                    '}';
        }


}
