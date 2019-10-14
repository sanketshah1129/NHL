package com.sanket.nhl.Model;

public class PeopleItem {
    private CurrentTeam currentTeam;
    private String lastName;
    private String birthStateProvince;
    private String link;
    private String rosterStatus;
    private String fullName;
    private int weight;
    private boolean active;
    private String birthCity;
    private boolean captain;
    private String birthDate;
    private boolean rookie;
    private String primaryNumber;
    private PrimaryPosition primaryPosition;
    private String firstName;
    private int currentAge;
    private String nationality;
    private boolean alternateCaptain;
    private String birthCountry;
    private int id;
    private String height;
    private String shootsCatches;

    public CurrentTeam getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(CurrentTeam currentTeam) {
        this.currentTeam = currentTeam;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthStateProvince() {
        return birthStateProvince;
    }

    public void setBirthStateProvince(String birthStateProvince) {
        this.birthStateProvince = birthStateProvince;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRosterStatus() {
        return rosterStatus;
    }

    public void setRosterStatus(String rosterStatus) {
        this.rosterStatus = rosterStatus;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isRookie() {
        return rookie;
    }

    public void setRookie(boolean rookie) {
        this.rookie = rookie;
    }

    public String getPrimaryNumber() {
        return primaryNumber;
    }

    public void setPrimaryNumber(String primaryNumber) {
        this.primaryNumber = primaryNumber;
    }

    public PrimaryPosition getPrimaryPosition() {
        return primaryPosition;
    }

    public void setPrimaryPosition(PrimaryPosition primaryPosition) {
        this.primaryPosition = primaryPosition;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isAlternateCaptain() {
        return alternateCaptain;
    }

    public void setAlternateCaptain(boolean alternateCaptain) {
        this.alternateCaptain = alternateCaptain;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getShootsCatches() {
        return shootsCatches;
    }

    public void setShootsCatches(String shootsCatches) {
        this.shootsCatches = shootsCatches;
    }

    @Override
    public String toString() {
        return
                "PeopleItem{" +
                        "currentTeam = '" + currentTeam + '\'' +
                        ",lastName = '" + lastName + '\'' +
                        ",birthStateProvince = '" + birthStateProvince + '\'' +
                        ",link = '" + link + '\'' +
                        ",rosterStatus = '" + rosterStatus + '\'' +
                        ",fullName = '" + fullName + '\'' +
                        ",weight = '" + weight + '\'' +
                        ",active = '" + active + '\'' +
                        ",birthCity = '" + birthCity + '\'' +
                        ",captain = '" + captain + '\'' +
                        ",birthDate = '" + birthDate + '\'' +
                        ",rookie = '" + rookie + '\'' +
                        ",primaryNumber = '" + primaryNumber + '\'' +
                        ",primaryPosition = '" + primaryPosition + '\'' +
                        ",firstName = '" + firstName + '\'' +
                        ",currentAge = '" + currentAge + '\'' +
                        ",nationality = '" + nationality + '\'' +
                        ",alternateCaptain = '" + alternateCaptain + '\'' +
                        ",birthCountry = '" + birthCountry + '\'' +
                        ",id = '" + id + '\'' +
                        ",height = '" + height + '\'' +
                        ",shootsCatches = '" + shootsCatches + '\'' +
                        "}";
    }
}
