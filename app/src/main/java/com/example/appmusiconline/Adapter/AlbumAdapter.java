package com.example.appmusiconline.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.appmusiconline.Model.Album;
import com.example.appmusiconline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHoder> {

    Context context;
    ArrayList<Album> mangalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View view = inflater.inflate( R.layout.dong_album, null);
        return new ViewHoder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder hoder, int position) {

        Album album = mangalbum.get(position);
        hoder.txtcasialbum.setText( album.getTenCaSiAlbum() );
        hoder.txttenalbum.setText( album.getTenAlbum() );
        Picasso.with( context ).load( album.getHinhAlbum() ).into( hoder.imghinhalbum );

    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public class ViewHoder extends ViewHolder {

        ImageView imghinhalbum;
        TextView txttenalbum, txtcasialbum;

        public ViewHoder(@NonNull View itemView) {
            super( itemView );
            imghinhalbum = itemView.findViewById( R.id.imageviewalbum );
            txttenalbum = itemView.findViewById( R.id.textviewtenalbum );
            txtcasialbum = itemView.findViewById( R.id.textviewtencasialbum );
        }
    }
}
