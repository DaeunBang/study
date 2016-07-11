package com.example.bangdaewoon.galleryapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class Gallery_Grid extends Activity {

    private Integer[] Blizzard={R.drawable.diablo3,R.drawable.heros,R.drawable.overwatch,R.drawable.starcraft2};//drawable 폴더의 이미지네임 왜 인테로형으로 하는지 몰겠음
    DisplayMetrics mMetrics;                                                                                    //해상도

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);

        GridView gridview=(GridView)findViewById(R.id.gridViewImages);
        gridview.setAdapter(new ImageAdapt(this));

        mMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
        
    }

    public class ImageAdapt extends BaseAdapter {
        private Context mContext;
        public ImageAdapt(Context c) {
            mContext=c;
        }

        @Override
        public int getCount() {
            return Blizzard.length;
        }

        @Override
        public Object getItem(int i) {
            return Blizzard[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            int rowWidth = (mMetrics.widthPixels) / 3;                  //너비 높이를 해상도 3으로 나눈값
            int rowheight = (mMetrics.heightPixels) / 3;
            ImageView imageView;
            if(view==null){
                imageView=new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(rowWidth,rowheight));   //너비높이 지정LayoutParams(너비,높이)
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);                  //CENTER_INSIDE: 이미지 비율유지
                imageView.setPadding(1, 1, 1, 1);
            }else{
                imageView=(ImageView) view;
            }
            imageView.setImageResource(Blizzard[i]);
            return imageView;
        }
    }
}
