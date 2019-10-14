package com.sanket.nhl.Model;

public class Division {
    private String name;
    private String link;
    private int id;
    private String abbreviation;
    private String nameShort;

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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    @Override
    public String toString() {
        return
                "Division{" +
                        "name = '" + name + '\'' +
                        ",link = '" + link + '\'' +
                        ",id = '" + id + '\'' +
                        ",abbreviation = '" + abbreviation + '\'' +
                        ",nameShort = '" + nameShort + '\'' +
                        "}";
    }
}
