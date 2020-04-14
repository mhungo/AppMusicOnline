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

import java.util.ArrayList;

public class DanhsachbaihatAdapter extends RecyclerView.Adapter<DanhsachbaihatAdapter.ViewHolder> {

    Context context;
    ArrayList<Baihat> mangbaihat;

    public DanhsachbaihatAdapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View view = inflater.inflate( R.layout.dong_danh_sach_bai_hat,viewGroup,false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Baihat baihat = mangbaihat.get( i );
        viewHolder.txtcasi.setText( baihat.getCasi());
        viewHolder.txttenbaihat.setText( baihat.getTenbaihat() );
        viewHolder.txtindex.setText( i+1+"" );
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex,txttenbaihat,txtcasi;
        ImageView imgluotthich;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            txtcasi = itemView.findViewById(R.id.textviewtencasi );
            txtindex = itemView.findViewById( R.id.textviewdanhsachindex );
            txttenbaihat = itemView.findViewById( R.id.textviewtenbaihat );
            imgluotthich = itemView.findViewById( R.id.imageviewdanhsachcakhuc );
        }

    }

}
