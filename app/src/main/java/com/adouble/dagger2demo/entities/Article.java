package com.adouble.dagger2demo.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by double on 2017/1/8.
 */
public class Article {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
