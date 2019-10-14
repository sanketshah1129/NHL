package com.sanket.nhl.Model;

import java.util.List;

public class Roster {
    private List<RosterItem> roster;
    private String link;

    public List<RosterItem> getRoster() {
        return roster;
    }

    public void setRoster(List<RosterItem> roster) {
        this.roster = roster;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return
                "Roster{" +
                        "roster = '" + roster + '\'' +
                        ",link = '" + link + '\'' +
                        "}";
    }
}