package com.sanket.nhl.Model;

public class Conference {
    private String name;
    private String link;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
                "Conference{" +
                        "name = '" + name + '\'' +
                        ",link = '" + link + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
