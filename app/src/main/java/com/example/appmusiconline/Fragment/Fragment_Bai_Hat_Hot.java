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


import com.example.appmusiconline.Adapter.BaihathotAdapter;
import com.example.appmusiconline.Model.Baihat;
import com.example.appmusiconline.R;
import com.example.appmusiconline.Service.APIService;
import com.example.appmusiconline.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Bai_Hat_Hot extends Fragment {

    View view;
    RecyclerView recyclerViewbaihathot;
    BaihathotAdapter baihathotAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_bai_hat_hot_nhat,container,false );
        recyclerViewbaihathot = view.findViewById( R.id.recyclerviewebaihathot );
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetBaiHatHot();
        callback.enqueue( new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> baihatArrayList = (ArrayList<Baihat>) response.body();
                baihathotAdapter = new BaihathotAdapter( getActivity(),baihatArrayList );
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity() );
                recyclerViewbaihathot.setLayoutManager( linearLayoutManager );
                recyclerViewbaihathot.setAdapter( baihathotAdapter );
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        } );
    }
}
