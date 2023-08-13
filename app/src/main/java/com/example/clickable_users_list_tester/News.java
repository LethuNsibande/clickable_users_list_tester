package com.example.clickable_users_list_tester;

public class News {
    String heading;
    int titleImage;

    public News(String heading, int titleImage) {
        this.heading = heading;
        this.titleImage = titleImage;
    }

    public String getHeading() {
        return heading;
    }

    public int getTitleImage() {
        return titleImage;
    }
}
