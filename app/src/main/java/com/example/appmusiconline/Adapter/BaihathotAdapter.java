package com.example.appmusiconline.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.appmusiconline.Model.Baihat;
import com.example.appmusiconline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHolder> {

    Context context;
    ArrayList<Baihat> baihatArrayList;

    public BaihathotAdapter(Context context, ArrayList<Baihat> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View view = inflater.inflate( R.layout.dong_bai_hat_hot,viewGroup,false);
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Baihat baihat = baihatArrayList.get( i );
        viewHolder.txtcasi.setText( baihat.getCasi() );
        viewHolder.txtten.setText( baihat.getTenbaihat() );
        Picasso.with( context ).load( baihat.getHinhbaihat() ).into( viewHolder.imghinh );

    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten,txtcasi;
        ImageView imghinh,imgluotthich;

        public ViewHolder(@NonNull View itemView) {

            super( itemView );
            txtten = itemView.findViewById( R.id.textviewtenbaihathot );
            txtcasi = itemView.findViewById( R.id.textviewtencasibaihathot );
            imghinh = itemView.findViewById( R.id.imageviewbaihathot );
            imgluotthich = itemView.findViewById( R.id.imageviewluotthich );
        }
    }

}
