package com.sanket.nhl.Model;

import java.util.List;

public class Response {
    private String copyright;
    private List<TeamsItem> teams;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<TeamsItem> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsItem> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return
                "PlayerResponse{" +
                        "copyright = '" + copyright + '\'' +
                        ",teams = '" + teams + '\'' +
                        "}";
    }

    public static class PlayerResponse {
        private String copyright;
        private List<PeopleItem> people;

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public List<PeopleItem> getPeople() {
            return people;
        }

        public void setPeople(List<PeopleItem> people) {
            this.people = people;
        }

        @Override
        public String toString() {
            return
                    "PlayerResponse{" +
                            "copyright = '" + copyright + '\'' +
                            ",people = '" + people + '\'' +
                            "}";
        }
    }
}