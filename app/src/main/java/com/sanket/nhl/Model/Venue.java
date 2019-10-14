package com.sanket.nhl.Model;

public class Venue {
    private String city;
    private String name;
    private String link;
    private TimeZone timeZone;
    private int id;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
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
                "Venue{" +
                        "city = '" + city + '\'' +
                        ",name = '" + name + '\'' +
                        ",link = '" + link + '\'' +
                        ",timeZone = '" + timeZone + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
