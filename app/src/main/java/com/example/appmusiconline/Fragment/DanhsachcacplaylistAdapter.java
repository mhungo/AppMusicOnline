package com.example.appmusiconline.Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.appmusiconline.Activity.DanhsachbaihatActivity;
import com.example.appmusiconline.Model.Playlist;
import com.example.appmusiconline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachcacplaylistAdapter extends RecyclerView.Adapter<DanhsachcacplaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<Playlist> mangplaylist;

    public DanhsachcacplaylistAdapter(Context context, ArrayList<Playlist> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate( R.layout.dong_danh_sach_cac_playlist,viewGroup,false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Playlist playlist = mangplaylist.get(position);
        Picasso.with(context).load(playlist.getHinhPlaylist()).into(viewHolder.imghinhnen);
        viewHolder.txttenplaylist.setText(playlist.getTen());

    }

    @Override
    public int getItemCount() {
        return mangplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnen;
        TextView txttenplaylist;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            imghinhnen = itemView.findViewById(R.id.imageviewdanhsachbaihatplaylist );
            txttenplaylist = itemView.findViewById( R.id.textviewtendanhsachcacplaylist );

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( context, DanhsachbaihatActivity.class );
                    intent.putExtra( "itemplaylist",mangplaylist.get( getPosition() ) );
                    context.startActivity(intent);    //Bai 36 xem lai
                }
            } );
        }
    }
}
