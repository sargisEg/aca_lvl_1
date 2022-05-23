package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.CatFactService;
import com.aca.homework.week21.post.service.core.RandomFactService;
import com.aca.homework.week21.post.RetrofitFactory;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

@Service
public class RandomFactServiceImpl implements RandomFactService {

    @Override
    public String getRandomFact() {
        CatFactService catFactService = RetrofitFactory.getRetrofit().create(CatFactService.class);
        final String[] fact = new String[1];
        try {
            final Response<Map<String, String>> execute = catFactService.getFact().execute();
            fact[0] = execute.body().get("fact");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fact[0];
    }
}
