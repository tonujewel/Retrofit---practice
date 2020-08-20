package com.jewel.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.jewel.retrofitpractice.adapter.PhotoAdapter;
import com.jewel.retrofitpractice.model.AlbumDM;
import com.jewel.retrofitpractice.network.ApiInstance;
import com.jewel.retrofitpractice.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private PhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        ApiInterface apiInterface = ApiInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<List<AlbumDM>> call = apiInterface.getAllPhotos();
        call.enqueue(new Callback<List<AlbumDM>>() {
            @Override
            public void onResponse(Call<List<AlbumDM>> call, Response<List<AlbumDM>> response) {
                progressDialog.dismiss();
                if (response!=null){
                    sendData(response.body());

                    Log.d("print_response1",response.body().toString());
                    Log.d("print_response2",response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<AlbumDM>> call, Throwable t) {

            }
        });
    }

    private void sendData(List<AlbumDM> body) {
        adapter = new PhotoAdapter(this,body);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}