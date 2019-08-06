package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar_Activity extends AppCompatActivity {

    EditText et_email, et_pass1, et_pass2;
    Button btn_registrar;

    DPHelper dp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_);

        dp = new DPHelper (this);

        et_email = (EditText) findViewById(R.id.rgt_email);
        et_pass1 = (EditText) findViewById(R.id.rgt_password);
        et_pass2 = (EditText) findViewById(R.id.rgt_password2);


        btn_registrar = (Button) findViewById(R.id.rgt_btn_registra);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = et_email.getText().toString();
                String password = et_pass1.getText().toString();
                String password2 = et_pass2.getText().toString();

                if (password.equals("")){

                    Toast.makeText(Registrar_Activity.this, "Preencha o campo Password",Toast.LENGTH_SHORT);
                }else if (password2.equals("")){

                    Toast.makeText(Registrar_Activity.this, "Preencha o campo Password2",Toast.LENGTH_SHORT);
                }else if (email.equals("")){

                    Toast.makeText(Registrar_Activity.this, "Preencha o campo Email",Toast.LENGTH_SHORT);
                }else {

                    long res =dp.CriarUtilizador(email,password);

                    if(res >0){

                        Toast.makeText(Registrar_Activity.this, "Registro OK",Toast.LENGTH_SHORT);

                    }else{

                        Toast.makeText(Registrar_Activity.this, "Registro Invalido",Toast.LENGTH_SHORT);
                    }


                }


            }
        });


    }
}
