package com.sanket.nhl.Model;

public class Person {
    private String link;
    private String fullName;
    private int id;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "Person{" +
                        "link = '" + link + '\'' +
                        ",fullName = '" + fullName + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
