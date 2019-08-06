package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_registra = (Button) findViewById(R.id.btn_registrar);
        Button btn_Login = (Button) findViewById(R.id.btn_Login);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent vai_pro_login = new Intent(MainActivity.this, Login_Activity.class);

                startActivity(vai_pro_login);

            }
        });


                btn_registra.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent vai_pro_registrar = new Intent(MainActivity.this, Registrar_Activity.class);
                        startActivity(vai_pro_registrar);

                    }
                });


    }
}
