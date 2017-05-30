package com.example.a15041867.c302_p06_miniproject;

/**
 * Created by 15041867 on 30/5/2017.
 */

public class TODO {
    private  int userId;
    private  String title;
    private boolean completed;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + "\n"
                + "Title: " + title + "\n"
                + "Completed: " + completed;
    }
}
