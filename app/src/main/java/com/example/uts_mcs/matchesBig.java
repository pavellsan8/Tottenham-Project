package com.example.uts_mcs;

public class matchesBig {
    int homeImage, awayImage;
    String title, date, time, stadium, homeTeam, awayTeam, ticket, vs, price;

    public matchesBig(int homeImage, int awayImage, String title, String date, String time, String stadium, String homeTeam, String awayTeam, String ticket, String vs, String price) {
        this.homeImage = homeImage;
        this.awayImage = awayImage;
        this.title = title;
        this.date = date;
        this.time = time;
        this.stadium = stadium;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.ticket = ticket;
        this.vs = vs;
        this.price = price;
    }

    public int getHomeImage() {
        return homeImage;
    }

    public void setHomeImage(int homeImage) {
        this.homeImage = homeImage;
    }

    public int getAwayImage() {
        return awayImage;
    }

    public void setAwayImage(int awayImage) {
        this.awayImage = awayImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getVs() {
        return vs;
    }

    public void setVs(String vs) {
        this.vs = vs;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}