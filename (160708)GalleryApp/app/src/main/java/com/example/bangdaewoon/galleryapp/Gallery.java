package com.example.bangdaewoon.galleryapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Gallery extends Activity {

    private ListView        m_ListView;
    private ArrayAdapter    m_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        final String[] Blizzard={"Diablo3","StarCraft2","HerosOfTheStorm","OverWatch"};

        m_ListView = (ListView)findViewById(R.id.listItem);
        m_Adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Blizzard);
        m_ListView.setAdapter(m_Adapter);

        m_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent=new Intent().setClass(Gallery.this,Gallery_Grid.class);
                //Toast.makeText(getApplicationContext(), "listclick",Toast.LENGTH_SHORT).show();
                startActivity(myIntent);
            }
        });
    }
}
