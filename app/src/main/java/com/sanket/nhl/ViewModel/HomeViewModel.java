package com.sanket.nhl.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sanket.nhl.Model.RosterItem;
import com.sanket.nhl.Model.TeamsItem;
import com.sanket.nhl.Utils.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private String textValue;

    private MutableLiveData<List<String>> positionList;
    private MutableLiveData<List<RosterItem>> playerList;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
    }

    public MutableLiveData<List<String>> getPositionNames() {
        return positionList;
    }

    public MutableLiveData<List<String>> loadPositions(List<TeamsItem> teamsItems, int id) {
        positionList = new MutableLiveData<>();

        List<RosterItem> roster = teamsItems.get(id).getRoster().getRoster();
        Collections.sort(roster, RosterItem.playerPositionComparator);

        List<String> positionDetails = new ArrayList<>();
        positionDetails.add(Common.SELECT_POSITION);


        for (RosterItem rosterItem : roster) {
            String positionName = rosterItem.getPosition().getName();
            if (!positionDetails.contains(positionName))
                positionDetails.add(positionName);
        }
        positionList.setValue(positionDetails);


        return getPositionNames();
    }


    public MutableLiveData<List<RosterItem>> getPlayersDetails() {
        return playerList;
    }

    public MutableLiveData<List<RosterItem>> loadTeamPlayers(List<TeamsItem> teamsItems, int id, String position) {

        playerList = new MutableLiveData<>();
        List<RosterItem> roster = teamsItems.get(id).getRoster().getRoster();

        if (position.equals(Common.SELECT_POSITION)) {
            playerList.setValue(roster);
        } else {

            List<RosterItem> filterRoster = new ArrayList<>();

            for (RosterItem rosterItem : roster) {
                String positionName = rosterItem.getPosition().getName();

                if (positionName.equals(position)) {
                    filterRoster.add(rosterItem);
                }
            }

            playerList.setValue(filterRoster);

        }
        return getPlayersDetails();
    }
}