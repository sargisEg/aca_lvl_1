package com.aca.homework.week20.retrofit.cat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://catfact.ninja/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        CatFactService catFactService = retrofit.create(CatFactService.class);

        Call<Map<String, String>> fact = catFactService.getFact();

        fact.enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
