package com.sanket.nhl.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class TeamsItem implements Parcelable {
    public static final Creator<TeamsItem> CREATOR = new Creator<TeamsItem>() {
        @Override
        public TeamsItem createFromParcel(Parcel in) {
            return new TeamsItem(in);
        }

        @Override
        public TeamsItem[] newArray(int size) {
            return new TeamsItem[size];
        }
    };
    private String teamName;
    private Venue venue;
    private Franchise franchise;
    private String locationName;
    private Conference conference;
    private String firstYearOfPlay;
    private String link;
    private String officialSiteUrl;
    private boolean active;
    private String abbreviation;
    private Division division;
    private Roster roster;
    private String name;
    private int franchiseId;
    private int id;
    private String shortName;

    protected TeamsItem(Parcel in) {
        teamName = in.readString();
        locationName = in.readString();
        firstYearOfPlay = in.readString();
        link = in.readString();
        officialSiteUrl = in.readString();
        active = in.readByte() != 0;
        abbreviation = in.readString();
        name = in.readString();
        franchiseId = in.readInt();
        id = in.readInt();
        shortName = in.readString();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public String getFirstYearOfPlay() {
        return firstYearOfPlay;
    }

    public void setFirstYearOfPlay(String firstYearOfPlay) {
        this.firstYearOfPlay = firstYearOfPlay;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getOfficialSiteUrl() {
        return officialSiteUrl;
    }

    public void setOfficialSiteUrl(String officialSiteUrl) {
        this.officialSiteUrl = officialSiteUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(int franchiseId) {
        this.franchiseId = franchiseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return
                "TeamsItem{" +
                        "teamName = '" + teamName + '\'' +
                        ",venue = '" + venue + '\'' +
                        ",franchise = '" + franchise + '\'' +
                        ",locationName = '" + locationName + '\'' +
                        ",conference = '" + conference + '\'' +
                        ",firstYearOfPlay = '" + firstYearOfPlay + '\'' +
                        ",link = '" + link + '\'' +
                        ",officialSiteUrl = '" + officialSiteUrl + '\'' +
                        ",active = '" + active + '\'' +
                        ",abbreviation = '" + abbreviation + '\'' +
                        ",division = '" + division + '\'' +
                        ",roster = '" + roster + '\'' +
                        ",name = '" + name + '\'' +
                        ",franchiseId = '" + franchiseId + '\'' +
                        ",id = '" + id + '\'' +
                        ",shortName = '" + shortName + '\'' +
                        "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(teamName);
        dest.writeString(locationName);
        dest.writeString(firstYearOfPlay);
        dest.writeString(link);
        dest.writeString(officialSiteUrl);
        dest.writeByte((byte) (active ? 1 : 0));
        dest.writeString(abbreviation);
        dest.writeString(name);
        dest.writeInt(franchiseId);
        dest.writeInt(id);
        dest.writeString(shortName);
    }
}
