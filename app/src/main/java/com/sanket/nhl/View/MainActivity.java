package com.sanket.nhl.View;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.sanket.nhl.Model.TeamsItem;
import com.sanket.nhl.R;
import com.sanket.nhl.Utils.Common;
import com.sanket.nhl.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    Toolbar toolbar;
    NavController navController;
    List<TeamsItem> teamsItems = new ArrayList<>();
    MutableLiveData<List<TeamsItem>> teamList = new MutableLiveData<>();
    MainViewModel viewModel;
    HomeFragment fragment;
    boolean playerName, playerNameDSC, playerJno, playerJnoDSC;
    private AppBarConfiguration mAppBarConfiguration;
    private HashMap<Integer, String> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);;
        fragment = new HomeFragment();

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        mAppBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setDrawerLayout(drawer)
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);

        playerName = false;
        playerNameDSC = true;
        playerJno = true;
        playerJnoDSC = false;


        viewModel.loadAllTeams().observe(this, new TeamObserver());
    }


    private void initNavigation(List<TeamsItem> teamList) {
        try {
            NavigationView navView = findViewById(R.id.nav_view);

            Menu menu = navView.getMenu();
            menu.clear();
            navView.invalidate();

            for (int i = 0; i < teamList.size(); i++) {
                TeamsItem teamDetails = teamList.get(i);

                String teamName = teamDetails.getTeamName();

                map.put(i, teamName);
                MenuItem item = menu.add(R.id.nav_home, i, i, teamName + " (" + (teamDetails.getLocationName() + ")"));
                item.setIcon(R.mipmap.ic_launcher);
                item.setCheckable(true);
            }

            onNavigationItemSelected(navView.getMenu().getItem(0));
            navView.getMenu().getItem(0).setChecked(true);
        } catch (Exception e) {
            Log.d("Exception", e.getMessage());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int group_id = menuItem.getGroupId();
        int id = menuItem.getItemId();

        if (group_id == R.id.nav_home) {
            if (map.size() > 0) {
                String title = map.get(id);
                toolbar.setTitle(title);

                Bundle bundle = new Bundle();
                bundle.putString(Common.TEAM_NAME, title);
                bundle.putInt(Common.TEAM_ID, id);
                bundle.putParcelableArrayList(Common.TEAM_LIST, (ArrayList<? extends Parcelable>) teamsItems);

                navController.popBackStack(R.id.nav_home, true);
                navController.navigate(R.id.nav_home, bundle);

            }

        } else {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private class TeamObserver implements Observer<List<TeamsItem>> {

        @Override
        public void onChanged(@Nullable List<TeamsItem> teamItem) {
            if (teamItem == null) return;
            else {
                teamsItems = teamItem;
                initNavigation(teamItem);
            }
        }
    }
}
