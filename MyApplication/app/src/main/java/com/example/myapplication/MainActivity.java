package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvPTM;
    private ArrayList<PTM> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPTM = findViewById(R.id.rv_ptm);
        rvPTM.setHasFixedSize(true);

        list.addAll(PTMData.getListData());
        showRecyclerList();

    }


    private void showRecyclerList() {
        rvPTM.setLayoutManager(new LinearLayoutManager(this));
        PTMAdapter listPtmAdapter = new PTMAdapter(list);
        rvPTM.setAdapter(listPtmAdapter);

        listPtmAdapter.setOnItemClickCallBack(new PTMAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(PTM data) {
                detailPTM(data);
            }
        });
    }

    private void detailPTM(PTM data) {
        Intent intent = new Intent(MainActivity.this, PTMDetail.class);
        intent.putExtra(PTMDetail.NAMA_PTM, data.getNama());
        intent.putExtra(PTMDetail.DESC, data.getDetail());
        intent.putExtra(PTMDetail.LOGO, data.getImg());
        startActivity(intent);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_menu, menu);
        menu.findItem(R.id.menu).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}



