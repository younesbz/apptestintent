package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button  button ;
    TextView  TVcont ;
    ImageView IVface , IVcall , IVcalon , IVpos;
    String call,location,website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        IVface = findViewById(R.id.IVface);
        IVcall = findViewById(R.id.IVcall);
        IVcalon = findViewById(R.id.IVcalon);
        IVpos = findViewById(R.id.IVpos);
        IVface.setVisibility(ImageView.GONE);
        IVcall.setVisibility(ImageView.GONE);
        IVcalon.setVisibility(ImageView.GONE);
        IVpos.setVisibility(ImageView.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextAct = new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(nextAct,1);
            }
        });
        IVcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextAct = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + call ));
                startActivity(nextAct);
            }
        });
        IVpos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextAct = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+ location));
                startActivity(nextAct);
            }
        });
        IVcalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextAct = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+website));
                startActivity(nextAct);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK) {
                int eta = data.getIntExtra("etat",0);
                if (eta == 1){
                    IVface.setImageResource(R.drawable.vry_satisfied);
                }else if (eta == 2) {
                    IVface.setImageResource(R.drawable.satisfied);
                }else {
                    IVface.setImageResource(R.drawable.dissatisfied);
                }
                call=data.getStringExtra("phone");
                location=data.getStringExtra("loca");
                website=data.getStringExtra("web");
                IVface.setVisibility(ImageView.VISIBLE);
                IVcall.setVisibility(ImageView.VISIBLE);
                IVcalon.setVisibility(ImageView.VISIBLE);
                IVpos.setVisibility(ImageView.VISIBLE);
            }else {
                IVface.setVisibility(ImageView.GONE);
                IVcall.setVisibility(ImageView.GONE);
                IVcalon.setVisibility(ImageView.GONE);
                IVpos.setVisibility(ImageView.GONE);
            }

        }
    }
}