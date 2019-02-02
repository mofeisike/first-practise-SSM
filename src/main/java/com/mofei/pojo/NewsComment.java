package com.mofei.pojo;
import java.io.Serializable;
import java.util.Date;


public class NewsComment implements Serializable {

    private int id;

    private int newid;

    private String comments;

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewid() {
        return newid;
    }

    public void setNewid(int newid) {
        this.newid = newid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "NewsComment{" +
                "id=" + id +
                ", newid=" + newid +
                ", comments='" + comments + '\'' +
                ", category=" + category +
                '}';
    }
}
