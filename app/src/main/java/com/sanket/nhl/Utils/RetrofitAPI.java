package com.sanket.nhl.Utils;

import com.sanket.nhl.Model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET("teams?expand=team.roster")
    Call<Response> getResponse();

    @GET
    Call<Response.PlayerResponse> getPlayerResponse(@Url String url);
}
