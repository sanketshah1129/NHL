package com.sanket.nhl.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sanket.nhl.Model.Response;
import com.sanket.nhl.Model.TeamsItem;
import com.sanket.nhl.Utils.RetrofitAPI;
import com.sanket.nhl.Utils.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainViewModel extends ViewModel {
    RetrofitAPI apiService;
    private MutableLiveData<List<TeamsItem>> teamList;
    private MutableLiveData<Boolean> isLoading;

    public MainViewModel() {
        apiService = RetrofitClient.getClient();
        teamList = new MutableLiveData<>();
        isLoading = new MutableLiveData<>();
    }


    private MutableLiveData<List<TeamsItem>> getTeams() {
        return teamList;
    }

    private void setTeams(List<TeamsItem> teams) {
        setIsLoading(false);
        teamList.postValue(teams);
    }

    private void setIsLoading(boolean loading) {
        isLoading.postValue(loading);
    }

    public MutableLiveData<List<TeamsItem>> loadAllTeams() {
        setIsLoading(true);
        Call<com.sanket.nhl.Model.Response> call = apiService.getResponse();
        call.enqueue(new getTeamsCallback());

        return getTeams();
    }

    private class getTeamsCallback implements Callback<Response> {

        @Override
        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

            if (response.isSuccessful()) {
                Response res = response.body();

                if (res != null) {
                    setTeams(res.getTeams());
                } else {
                    setTeams(Collections.<TeamsItem>emptyList());
                }
            }
        }

        @Override
        public void onFailure(Call<com.sanket.nhl.Model.Response> call, Throwable t) {
            setTeams(Collections.<TeamsItem>emptyList());
        }

    }
}
