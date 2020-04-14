package com.example.appmusiconline.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.appmusiconline.Adapter.DanhsachbaihatAdapter;
import com.example.appmusiconline.Model.Baihat;
import com.example.appmusiconline.Model.Playlist;
import com.example.appmusiconline.Model.Quangcao;
import com.example.appmusiconline.Model.TheLoai;
import com.example.appmusiconline.R;
import com.example.appmusiconline.Service.APIService;
import com.example.appmusiconline.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar1;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    Quangcao quangcao;
    ImageView imgdanhsachcakhuc;
    ArrayList<Baihat> mangbaihat;
    DanhsachbaihatAdapter danhsachbaihatAdapter;
    Playlist playlist;
    TheLoai theLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_danhsachbaihat );
        DataIntent();
        anhxa();
        init();

        if(quangcao != null && !quangcao.getTenbaihat().equals( "" )){
            setValueInView(quangcao.getTenbaihat(),quangcao.getHinhanh());
            GetDataQuangcao(quangcao.getIdQuangcao());
        }
        if(playlist != null && !playlist.getTen().equals( "" )){
            setValueInView(playlist.getTen(),playlist.getHinhPlaylist() );
            GetDataPlaylist(playlist.getIdPlaylist());
        }
        if(theLoai != null && !theLoai.getTenTheLoai().equals( "" )){
            setValueInView( theLoai.getTenTheLoai(),theLoai.getHinhTheLoai() );
            GetDataTheLoai( theLoai.getIdTheLoai() );
        }
    }

    private void init() {
        setSupportActionBar( toolbar1 );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        toolbar1.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        collapsingToolbarLayout.setExpandedTitleColor( Color.WHITE );
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE );
    }

    private void GetDataTheLoai(String idtheloai) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihatheotheloai(idtheloai);
        callback.enqueue( new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter( DanhsachbaihatActivity.this ,mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager( new LinearLayoutManager( DanhsachbaihatActivity.this ) );
                recyclerViewdanhsachbaihat.setAdapter( danhsachbaihatAdapter );
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        } );

    }

    private void GetDataPlaylist(String idplaylist) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihattheoplaylist(idplaylist);
        callback.enqueue( new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter( DanhsachbaihatActivity.this ,mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager( new LinearLayoutManager( DanhsachbaihatActivity.this ) );
                recyclerViewdanhsachbaihat.setAdapter( danhsachbaihatAdapter );
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        } );

    }

    private void GetDataQuangcao(String idquangcao) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihattheoquangcao(idquangcao);
        callback.enqueue( new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter( DanhsachbaihatActivity.this ,mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager( new LinearLayoutManager( DanhsachbaihatActivity.this ) );
                recyclerViewdanhsachbaihat.setAdapter( danhsachbaihatAdapter );
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        } );
    }

    private void setValueInView(String tenbaihat, String hinhanh) {
        collapsingToolbarLayout.setTitle( tenbaihat );
        try {
            URL url = new URL( hinhanh );
            Bitmap bitmap = BitmapFactory.decodeStream( url.openConnection().getInputStream() );
            BitmapDrawable bitmapDrawable = new BitmapDrawable( getResources(),bitmap );
            collapsingToolbarLayout.setBackground( bitmapDrawable );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with( this ).load( hinhanh ).into( imgdanhsachcakhuc );
    }



    private void anhxa() {
        coordinatorLayout = findViewById( R.id.coordinatorlayout );
        collapsingToolbarLayout = findViewById( R.id.collapsingtoolbar );
        toolbar1 = findViewById( R.id.toolbardanhsach );
        recyclerViewdanhsachbaihat = findViewById( R.id.recyclerviewdanhsachbaihat );
        floatingActionButton = findViewById( R.id.floatingactionbutton );
        imgdanhsachcakhuc = findViewById( R.id.imageviewdanhsachcakhuc );
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null) {
            if (intent.hasExtra( "banner" )) {
                quangcao = (Quangcao) intent.getSerializableExtra( "banner" );
            }
            if (intent.hasExtra( "itemplaylist" )) {
                playlist = (Playlist) intent.getSerializableExtra( "itemplaylist" );
            }
            if (intent.hasExtra( "idtheloai" )) {
                theLoai = (TheLoai) intent.getSerializableExtra( "idtheloai" );
            }
        }
    }
}
