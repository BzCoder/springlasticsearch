package com.example.springlasticsearch.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author BaoZhou
 * @date 2018/6/7
 */
@Document(indexName = "test", type = "book")
public class TestBean {
    Integer id;
    String name;
    String author;
    public TestBean() {

    }

    public TestBean(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
