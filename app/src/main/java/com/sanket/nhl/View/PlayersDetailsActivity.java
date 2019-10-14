package com.sanket.nhl.View;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.haipq.android.flagkit.FlagImageView;
import com.neovisionaries.i18n.CountryCode;
import com.sanket.nhl.Model.PeopleItem;
import com.sanket.nhl.R;
import com.sanket.nhl.Utils.Common;
import com.sanket.nhl.ViewModel.PlayerDetailsViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PlayersDetailsActivity extends AppCompatActivity {

    private TextView tvFullName;
    private TextView tvNationality;
    private TextView tvBirthdate;
    private TextView tvBirthPlace;
    private TextView tvPosition;
    private TextView tvJerseyNo;
    private FlagImageView flagImageView;

    private PlayerDetailsViewModel viewModel;

    private String playerName, playerPosition, playerJerseyNo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_details);

        String playerID = getIntent().getStringExtra(Common.PLAYER_ID);
        playerName = getIntent().getStringExtra(Common.PLAYER_NAME);
        playerPosition = getIntent().getStringExtra(Common.PLAYER_POSITION);
        playerJerseyNo = getIntent().getStringExtra(Common.PLAYER_JERSEYNO);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews(playerID);
    }

    private void initViews(String playerID) {
        tvFullName = findViewById(R.id.tvFullName);
        tvNationality = findViewById(R.id.tvNationality);
        tvBirthdate = findViewById(R.id.tvBirthdate);
        tvBirthPlace = findViewById(R.id.tvBirthPlace);
        tvPosition = findViewById(R.id.tvPosition);
        tvJerseyNo = findViewById(R.id.tvJerseyNo);

        flagImageView = findViewById(R.id.flagView);

        viewModel = new PlayerDetailsViewModel(playerID);
        viewModel.loadPeopleDetails().observe(this, new PlayerObserver());
    }

    private void setValuesToViews(List<PeopleItem> peopleItems) {
        tvFullName.setText(playerName);
        tvPosition.setText(playerPosition);
        tvJerseyNo.setText("#" + playerJerseyNo);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(peopleItems.get(0).getBirthDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        format.applyLocalizedPattern("MMMM dd, yyyy");
        String birthDate = format.format(date);

        tvBirthdate.setText(birthDate + " (" + peopleItems.get(0).getCurrentAge() + " Years)");
        tvBirthPlace.setText(peopleItems.get(0).getBirthCity());

        CountryCode countryCode = CountryCode.valueOf(CountryCode.getByAlpha3Code(peopleItems.get(0).getNationality()).getAlpha2());
        String countryName = CountryCode.getByCode(countryCode.getAlpha2().toUpperCase()).getName().toUpperCase();

        tvNationality.setText(countryName);
        flagImageView.setCountryCode(countryCode.getAlpha2().toUpperCase());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class PlayerObserver implements Observer<List<PeopleItem>> {

        @Override
        public void onChanged(@Nullable List<PeopleItem> peopleItem) {
            if (peopleItem == null) return;
            else {
                setValuesToViews(peopleItem);
            }
        }
    }
}