package com.example.appmusiconline.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.appmusiconline.Activity.DanhsachbaihatActivity;
import com.example.appmusiconline.Model.Quangcao;
import com.example.appmusiconline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Quangcao> arrayListbanner;

    public BannerAdapter(Context context, ArrayList<Quangcao> arrayListbanner) {
        this.context = context;
        this.arrayListbanner = arrayListbanner;
    }

    @Override
    public int getCount() {
        return arrayListbanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
      LayoutInflater inflater = LayoutInflater.from( context );
      View view = inflater.inflate( R.layout.dong_banner,container,false );

        ImageView imgbackgroundbanner = view.findViewById( R.id.imageviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
        TextView txttitlesongbanner = view.findViewById(R.id.textviewtitlebbannerbaihat);
        TextView txtnoidung = view.findViewById(R.id.textviewnoidung);

        Picasso.with(context).load(arrayListbanner.get(position).getHinhanh()).into(imgbackgroundbanner);
        Picasso.with(context).load(arrayListbanner.get(position).getHinhBaihat()).into(imgsongbanner);
        txttitlesongbanner.setText(arrayListbanner.get(position).getTenbaihat());
        txtnoidung.setText(arrayListbanner.get(position).getNoidung());

        view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( context, DanhsachbaihatActivity.class );
                intent.putExtra( "banner",arrayListbanner.get( position ) );
                context.startActivity( intent );
            }
        } );

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView( (View) object );
    }
}
