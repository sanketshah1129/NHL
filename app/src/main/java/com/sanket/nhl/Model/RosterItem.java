package com.sanket.nhl.Model;

import java.util.Comparator;

public class RosterItem {
    public static Comparator<RosterItem> playerNameASCComparator = new Comparator<RosterItem>() {

        public int compare(RosterItem r1, RosterItem r2) {
            String PlayerName1 = r1.getPerson().getFullName().toUpperCase();
            String PlayerName2 = r2.getPerson().getFullName().toUpperCase();

            return PlayerName1.compareTo(PlayerName2);

        }
    };
    public static Comparator<RosterItem> playerNameDSCComparator = new Comparator<RosterItem>() {

        public int compare(RosterItem r1, RosterItem r2) {
            String PlayerName1 = r1.getPerson().getFullName().toUpperCase();
            String PlayerName2 = r2.getPerson().getFullName().toUpperCase();

            return PlayerName2.compareTo(PlayerName1);
        }
    };
    public static Comparator<RosterItem> playerJerseyNoASCComparator = new Comparator<RosterItem>() {

        public int compare(RosterItem r1, RosterItem r2) {

            int jNo1 = Integer.valueOf(r1.getJerseyNumber());
            int jNo2 = Integer.valueOf(r2.getJerseyNumber());

            return jNo1 - jNo2;
        }
    };
    public static Comparator<RosterItem> playerJerseyNoDSCComparator = new Comparator<RosterItem>() {

        public int compare(RosterItem r1, RosterItem r2) {

            int jNo1 = Integer.valueOf(r1.getJerseyNumber());
            int jNo2 = Integer.valueOf(r2.getJerseyNumber());

            return jNo2 - jNo1;
        }
    };

    private Person person;
    private String jerseyNumber;
    private Position position;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return
                "RosterItem{" +
                        "person = '" + person + '\'' +
                        ",jerseyNumber = '" + jerseyNumber + '\'' +
                        ",position = '" + position + '\'' +
                        "}";
    }
}
