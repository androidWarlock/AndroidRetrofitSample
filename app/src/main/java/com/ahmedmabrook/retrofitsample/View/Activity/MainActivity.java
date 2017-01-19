package com.ahmedmabrook.retrofitsample.view.activity;

import android.os.Bundle;

import com.ahmedmabrook.retrofitsample.R;
import com.ahmedmabrook.retrofitsample.domain.mapper.ApiMapper;
import com.ahmedmabrook.retrofitsample.domain.mapper.networkingLayer.RetrofitClient;
import com.ahmedmabrook.retrofitsample.domain.model.MovieResponse;
import com.ahmedmabrook.retrofitsample.utils.Toaster;
import com.ahmedmabrook.retrofitsample.view.activity.parent.RetrofitSampleActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ahmedmabrook.retrofitsample.utils.config.API_KEY;


public class MainActivity extends RetrofitSampleActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiMapper apiMapper = RetrofitClient.getClient().create(ApiMapper.class);

        Call<MovieResponse> getTopRatedMoviesCall = apiMapper.getTopRatedMovies(API_KEY);

        getTopRatedMoviesCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                Toaster.with(MainActivity.this).LogAndToast(String.valueOf(response.body().getResults().size()));

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toaster.with(MainActivity.this).LogAndToast(t.getMessage());
            }
        });

    }
}
