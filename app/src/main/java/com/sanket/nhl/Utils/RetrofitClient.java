package com.sanket.nhl.Utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static RetrofitAPI getClient() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    /*.connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(2, TimeUnit.MINUTES)
                    .readTimeout(2, TimeUnit.MINUTES)
                    .addInterceptor(new LoggingInterceptor())
                    .retryOnConnectionFailure(true)*/
                    .build();


            retrofit = new Retrofit.Builder()
                    .baseUrl(Common.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitAPI.class);
    }
}

