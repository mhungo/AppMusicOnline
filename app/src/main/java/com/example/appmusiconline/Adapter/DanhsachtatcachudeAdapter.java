package com.example.appmusiconline.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.appmusiconline.Activity.DanhsachtatcachudeActivity;
import com.example.appmusiconline.Activity.DanhsachtheloaitheochudeActivity;
import com.example.appmusiconline.Model.ChuDe;
import com.example.appmusiconline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtatcachudeAdapter extends RecyclerView.Adapter<DanhsachtatcachudeAdapter.ViewHolder> {

    Context context;
    ArrayList<ChuDe> mangchude;

    public DanhsachtatcachudeAdapter(Context context, ArrayList<ChuDe> mangchude) {
        this.context = context;
        this.mangchude = mangchude;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View view = inflater.inflate( R.layout.dong_cac_chu_de,viewGroup,false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        ChuDe chuDe = mangchude.get( i );
        Picasso.with( context ).load( chuDe.getHinhChuDe()).into( viewHolder.imgchude);

    }

    @Override
    public int getItemCount() {
        return mangchude.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgchude;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            imgchude = itemView.findViewById( R.id.imageviewdongcacchude );
            imgchude.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( context, DanhsachtheloaitheochudeActivity.class );
                    intent.putExtra( "chude",mangchude.get( getPosition() ) );
                    context.startActivity( intent );
                }
            } );

        }
    }
}
