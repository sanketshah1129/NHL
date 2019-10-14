package com.sanket.nhl.Model;

public class Franchise {
    private String teamName;
    private String link;
    private int franchiseId;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(int franchiseId) {
        this.franchiseId = franchiseId;
    }

    @Override
    public String toString() {
        return
                "Franchise{" +
                        "teamName = '" + teamName + '\'' +
                        ",link = '" + link + '\'' +
                        ",franchiseId = '" + franchiseId + '\'' +
                        "}";
    }
}
