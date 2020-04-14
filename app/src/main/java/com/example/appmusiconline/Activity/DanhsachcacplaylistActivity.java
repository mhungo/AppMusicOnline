package com.example.appmusiconline.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.appmusiconline.Fragment.DanhsachcacplaylistAdapter;
import com.example.appmusiconline.Model.Playlist;
import com.example.appmusiconline.R;
import com.example.appmusiconline.Service.APIService;
import com.example.appmusiconline.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachcacplaylistActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachcacplaylist;
    DanhsachcacplaylistAdapter danhsachcacplaylistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_danhsachcacplaylist );
        anhxa();
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callback = dataservice.GetDanhsachcacplaylist();
        callback.enqueue( new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> mangplaylist = (ArrayList<Playlist>) response.body();
                danhsachcacplaylistAdapter = new DanhsachcacplaylistAdapter( DanhsachcacplaylistActivity.this,mangplaylist );
                recyclerViewdanhsachcacplaylist.setLayoutManager( new GridLayoutManager( DanhsachcacplaylistActivity.this,2 ) );
                recyclerViewdanhsachcacplaylist.setAdapter( danhsachcacplaylistAdapter );
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        } );
    }

    private void init() {
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setTitle("Playlist Nổi Bật");
        toolbar.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );

    }

    private void anhxa() {
        toolbar = findViewById( R.id.toobardanhsachcacplaylist );
        recyclerViewdanhsachcacplaylist = findViewById( R.id.reclerviewdanhsachcacplaylist );

    }
}
