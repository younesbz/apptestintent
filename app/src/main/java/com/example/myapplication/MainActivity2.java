package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    EditText editTextTextPersonName2 ,editTextTextPersonName3 ,editTextTextPersonName4 , editTextTextPersonName5;
    ImageView imageView , imageView2 , imageView3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName5);

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextAct = new Intent(MainActivity2.this,MainActivity.class);
                nextAct.putExtra("name",editTextTextPersonName2.getText().toString());
                nextAct.putExtra("phone",editTextTextPersonName3.getText().toString());
                nextAct.putExtra("web",editTextTextPersonName4.getText().toString());
                nextAct.putExtra("loca",editTextTextPersonName5.getText().toString());
                nextAct.putExtra("etat",3);
                setResult(RESULT_OK,nextAct);
                MainActivity2.this.finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextAct = new Intent(MainActivity2.this,MainActivity.class);
                nextAct.putExtra("name",editTextTextPersonName2.getText().toString());
                nextAct.putExtra("phone",editTextTextPersonName3.getText().toString());
                nextAct.putExtra("web",editTextTextPersonName4.getText().toString());
                nextAct.putExtra("loca",editTextTextPersonName5.getText().toString());
                nextAct.putExtra("etat",1);
                setResult(RESULT_OK,nextAct);
                MainActivity2.this.finish();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextAct = new Intent(MainActivity2.this,MainActivity.class);
                nextAct.putExtra("name",editTextTextPersonName2.getText().toString());
                nextAct.putExtra("phone",editTextTextPersonName3.getText().toString());
                nextAct.putExtra("web",editTextTextPersonName4.getText().toString());
                nextAct.putExtra("loca",editTextTextPersonName5.getText().toString());
                nextAct.putExtra("etat",2);
                setResult(RESULT_OK,nextAct);
                MainActivity2.this.finish();
            }
        });

    }
}