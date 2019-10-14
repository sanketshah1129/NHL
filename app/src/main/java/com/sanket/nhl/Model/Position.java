package com.sanket.nhl.Model;

public class Position {
    private String code;
    private String name;
    private String type;
    private String abbreviation;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return
                "Position{" +
                        "code = '" + code + '\'' +
                        ",name = '" + name + '\'' +
                        ",type = '" + type + '\'' +
                        ",abbreviation = '" + abbreviation + '\'' +
                        "}";
    }
}
