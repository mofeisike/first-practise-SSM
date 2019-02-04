package com.mofei.pojo;
import java.io.Serializable;


public class Entry implements Serializable {

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", category=" + category +
                '}';
    }

    private int id;

    private int cid;

    private String name;

    private String introduce;

    private Category category;

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}