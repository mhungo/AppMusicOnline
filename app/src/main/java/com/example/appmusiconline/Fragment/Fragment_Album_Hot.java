package com.example.appmusiconline.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.appmusiconline.Adapter.AlbumAdapter;
import com.example.appmusiconline.Model.Album;
import com.example.appmusiconline.R;
import com.example.appmusiconline.Service.APIService;
import com.example.appmusiconline.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Album_Hot extends Fragment {

    View view;
    RecyclerView recyclerView;
    TextView txtxemthemalbum;
    AlbumAdapter albumAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_album_hot, container, false );
        recyclerView = view.findViewById( R.id.recyclerviewalbum );
        txtxemthemalbum = view.findViewById( R.id.textviewtxemthemalbum );
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAlbumHot();
        callback.enqueue( new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> albumArrayList = (ArrayList<Album>) response.body();
                albumAdapter = new AlbumAdapter( getActivity(),albumArrayList );
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity() );
                linearLayoutManager.setOrientation( LinearLayoutManager.HORIZONTAL );
                recyclerView.setLayoutManager( linearLayoutManager );
                recyclerView.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        } );

    }
}
