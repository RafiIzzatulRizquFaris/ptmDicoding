package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PTMDetail extends AppCompatActivity {

    ImageView img;
    TextView nmptm, desc;

    public static String NAMA_PTM = "ptm_nama";
    public static String DESC = "deskripsi";
    public static String LOGO = "logo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptm_detail);

        img = findViewById(R.id.logo2);
        nmptm = findViewById(R.id.nmptm2);
        desc = findViewById(R.id.desc2);


        Glide.with(this).load(getIntent().getIntExtra(LOGO,0)).into(img);
        nmptm.setText(getIntent().getStringExtra(NAMA_PTM));
        desc.setText(getIntent().getStringExtra(DESC));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getIntent().getStringExtra(NAMA_PTM));
        }
    }

    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
