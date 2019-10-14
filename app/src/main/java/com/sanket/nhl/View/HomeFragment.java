package com.sanket.nhl.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sanket.nhl.Adapter.PlayerAdapter;
import com.sanket.nhl.Model.RosterItem;
import com.sanket.nhl.Model.TeamsItem;
import com.sanket.nhl.R;
import com.sanket.nhl.Utils.Common;
import com.sanket.nhl.ViewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView rvPlayers;
    Spinner spPosition;
    List<RosterItem> playerList;
    List<TeamsItem> teamsItems = new ArrayList<>();
    boolean playerNameASC, playerNameDSC, playerJnoASC, playerJnoDSC;
    private Context context;
    private int teamID;
    private String title;
    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        setHasOptionsMenu(true);

        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString(Common.TEAM_NAME);
            teamID = bundle.getInt(Common.TEAM_ID);
            teamsItems = bundle.getParcelableArrayList(Common.TEAM_LIST);

            getActivity().setTitle(title);
        }

        playerNameASC = false;
        playerNameDSC = true;
        playerJnoASC = true;
        playerJnoDSC = false;

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        rvPlayers = root.findViewById(R.id.rvPlayers);
        spPosition = root.findViewById(R.id.spPosition);

        if (teamsItems.size() > 0) {
            homeViewModel.loadPositions(teamsItems, teamID).observe(this, new PositionObserver());
            ;

            rvPlayers.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            rvPlayers.setLayoutManager(layoutManager);
            homeViewModel.loadTeamPlayers(teamsItems, teamID, Common.SELECT_POSITION).observe(this, new PlayerDetailsObserver());
        }

        return root;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sortByName) {
            if (playerNameASC) {
                playerNameASC = false;
                playerNameDSC = true;
                initRecyclerview(playerList, RosterItem.playerNameASCComparator);
            } else if (playerNameDSC) {
                playerNameASC = true;
                playerNameDSC = false;
                initRecyclerview(playerList, RosterItem.playerNameDSCComparator);
            }

        } else if (item.getItemId() == R.id.action_sortByJerseyNo) {
            if (playerJnoASC) {
                playerJnoASC = false;
                playerJnoDSC = true;
                initRecyclerview(playerList, RosterItem.playerJerseyNoASCComparator);
            } else if (playerJnoDSC) {
                playerJnoASC = true;
                playerJnoDSC = false;
                initRecyclerview(playerList, RosterItem.playerJerseyNoDSCComparator);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void initRecyclerview(final List<RosterItem> playerList, Comparator<RosterItem> comparator) {
        Collections.sort(playerList, comparator);
        PlayerAdapter playerAdapter = new PlayerAdapter(context, playerList);
        playerAdapter.notifyDataSetChanged();

        rvPlayers.setAdapter(playerAdapter);
        rvPlayers.invalidate();
    }

    private void initSpinnerView(final List<String> positionArray, Comparator<RosterItem> comparator) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, positionArray);
        spPosition.setAdapter(dataAdapter);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spPosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedPositionName = positionArray.get(position);
                homeViewModel.loadTeamPlayers(teamsItems, teamID, selectedPositionName).observe((LifecycleOwner) context, new PlayerDetailsObserver());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private class PlayerDetailsObserver implements Observer<List<RosterItem>> {

        @Override
        public void onChanged(@Nullable List<RosterItem> peopleItem) {
            if (peopleItem == null) return;
            else {
                playerList = new ArrayList<>();
                playerList = peopleItem;
                initRecyclerview(peopleItem, RosterItem.playerNameASCComparator);
            }
        }
    }

    private class PositionObserver implements Observer<List<String>> {

        @Override
        public void onChanged(@Nullable List<String> positionArray) {
            if (positionArray == null) return;
            else {
                initSpinnerView(positionArray, RosterItem.playerPositionComparator);
            }
        }
    }
}