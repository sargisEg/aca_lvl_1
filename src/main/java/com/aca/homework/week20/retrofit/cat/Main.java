package com.aca.homework.week20.retrofit.cat;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://catfact.ninja/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        CatFactService catFactService = retrofit.create(CatFactService.class);

        Call<CatFactDto> fact = catFactService.getFact();

        final Response<CatFactDto> catFactDtoResponse;
        try {
            catFactDtoResponse = fact.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(catFactDtoResponse.body().getFact());
    }
}
