package com.example.uts_mcs;

public class matches {
    int image;
    String date, time;

    public matches(int image, String date, String time) {
        this.image = image;
        this.date = date;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
}
