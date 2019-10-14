package com.sanket.nhl.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sanket.nhl.Model.Response;
import com.sanket.nhl.Model.Roster;
import com.sanket.nhl.Model.RosterItem;
import com.sanket.nhl.Model.TeamsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private String textValue;

    private MutableLiveData<List<RosterItem>> playerList;

    public HomeViewModel() {
        mText = new MutableLiveData<>();

    }

    public MutableLiveData<List<RosterItem>> getPlayersDetails()
    {
        return playerList;
    }

    public MutableLiveData<List<RosterItem>> loadAllTeamPlayers(List<TeamsItem> teamsItems, int id) {
        playerList = new MutableLiveData<>();

        List<RosterItem> roster = teamsItems.get(id).getRoster().getRoster();
        playerList.setValue(roster);

        return getPlayersDetails();
    }
}