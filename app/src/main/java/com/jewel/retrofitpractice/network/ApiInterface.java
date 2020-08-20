package com.jewel.retrofitpractice.network;


import com.jewel.retrofitpractice.model.AlbumDM;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("photos")
    Call<List<AlbumDM>> getAllPhotos();
}