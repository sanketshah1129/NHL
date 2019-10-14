package com.sanket.nhl.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sanket.nhl.Model.PeopleItem;
import com.sanket.nhl.Model.Response;
import com.sanket.nhl.Utils.Common;
import com.sanket.nhl.Utils.RetrofitAPI;
import com.sanket.nhl.Utils.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class PlayerDetailsViewModel extends ViewModel {
    RetrofitAPI apiService;
    String playerID;
    private MutableLiveData<List<PeopleItem>> peopleList;

    public PlayerDetailsViewModel(String playerID) {
        apiService = RetrofitClient.getClient();
        this.playerID = playerID;
        peopleList = new MutableLiveData<>();
    }

    private MutableLiveData<List<PeopleItem>> getPeopleDetails() {
        return peopleList;
    }

    private void setPeopleDetails(List<PeopleItem> peopleItems) {
        peopleList.postValue(peopleItems);
    }

    public MutableLiveData<List<PeopleItem>> loadPeopleDetails() {
        Call<com.sanket.nhl.Model.Response.PlayerResponse> call = apiService.getPlayerResponse(Common.BASE_URL + "people/" + playerID);
        call.enqueue(new getPeopleDetailsCallback());

        return getPeopleDetails();
    }

    private class getPeopleDetailsCallback implements Callback<Response.PlayerResponse> {

        @Override
        public void onResponse(Call<Response.PlayerResponse> call, retrofit2.Response<Response.PlayerResponse> response) {
            if (response.isSuccessful()) {
                Response.PlayerResponse res = response.body();

                if (res != null) {
                    setPeopleDetails(res.getPeople());
                } else {
                    setPeopleDetails(Collections.<PeopleItem>emptyList());
                }
            }
        }

        @Override
        public void onFailure(Call<Response.PlayerResponse> call, Throwable t) {
            setPeopleDetails(Collections.<PeopleItem>emptyList());
        }
    }
}


