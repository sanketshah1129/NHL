package com.sanket.nhl.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    List<RosterItem> playerList;
    List<TeamsItem> teamsItems = new ArrayList<>();
    boolean playerNameASC, playerNameDSC, playerJnoASC, playerJnoDSC;
    private Context context;
    private int id;
    private String title;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        setHasOptionsMenu(true);

        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString(Common.TEAM_NAME);
            id = bundle.getInt(Common.TEAM_ID);
            teamsItems = bundle.getParcelableArrayList(Common.TEAM_LIST);

            getActivity().setTitle(title);
        }

        playerNameASC = false;
        playerNameDSC = true;
        playerJnoASC = true;
        playerJnoDSC = false;

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        rvPlayers = root.findViewById(R.id. rvPlayers);

        if (teamsItems.size() > 0)
        {
            rvPlayers.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            rvPlayers.setLayoutManager(layoutManager);
            homeViewModel.loadAllTeamPlayers(teamsItems, id).observe(this, new PlayerDetailsObserver());
        }

        return root;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.action_sortByName)
        {
             if (playerNameASC) {
                 playerNameASC = false;
                playerNameDSC = true;
                initRecyclerview(playerList, RosterItem.playerNameASCComparator);
            } else if (playerNameDSC) {
                 playerNameASC = true;
                 playerNameDSC = false;
                initRecyclerview(playerList, RosterItem.playerNameDSCComparator);
            }

        }
        else if(item.getItemId() == R.id.action_sortByJerseyNo)
        {
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

    private void initRecyclerview(List<RosterItem> playerList, Comparator<RosterItem> comparator)
    {
        Collections.sort(playerList, comparator);
        //PlayerAdapter playerAdapter = new PlayerAdapter(context, playerList);
        PlayerDetailAdapter playerAdapter = new PlayerDetailAdapter(context, playerList);
        playerAdapter.notifyDataSetChanged();

        rvPlayers.setAdapter(playerAdapter);
        rvPlayers.invalidate();
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
}