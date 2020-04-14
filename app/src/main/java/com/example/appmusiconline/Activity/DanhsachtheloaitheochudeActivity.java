package com.example.appmusiconline.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.appmusiconline.Model.ChuDe;
import com.example.appmusiconline.Model.TheLoai;
import com.example.appmusiconline.R;
import com.example.appmusiconline.Service.APIService;
import com.example.appmusiconline.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtheloaitheochudeActivity extends AppCompatActivity {

    ChuDe chuDe;
    RecyclerView recyclerViewtheloaitheochude;
    Toolbar toolbartheloaitheochude;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_danhsachtheloaitheochude );
        GetIntent();
        init();
        GetData();

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<TheLoai>> callback = dataservice.GetTheloaitheochude( chuDe.getIdChuDe() );
        callback.enqueue( new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                ArrayList<TheLoai> mangtheloai = (ArrayList<TheLoai>) response.body();
            }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }
        } );
    }

    private void init() {
        recyclerViewtheloaitheochude = findViewById( R.id.reclerviewtheloaitheochude );
        toolbartheloaitheochude = findViewById( R.id.toolbartheloaitheochude );
        setSupportActionBar( toolbartheloaitheochude );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setTitle( chuDe.getTenChuDe() );
        toolbartheloaitheochude.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
    }

    private void GetIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra( "chude" )){
            chuDe = (ChuDe) intent.getSerializableExtra( "chude" );

        }
    }
}
