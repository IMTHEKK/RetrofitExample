package com.abc.example;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class Api {

    static ApiInterface getClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://devfrontend.gscmaven.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }
}

