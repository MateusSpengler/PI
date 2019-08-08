package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    EditText et_email,et_password;
    Button btn_login;

DPHelper dp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        dp = new DPHelper(this);

        et_email = (EditText) findViewById(R.id.lgn_email);
        et_password = (EditText) findViewById( R.id.lgn_password);

        btn_login = (Button) findViewById(R.id.lgn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            String email = et_email.getText().toString();
            String password = et_password.getText().toString();


            if (email.equals("")){

                Toast.makeText(Login_Activity.this,"Coloque o email",Toast.LENGTH_SHORT).show();

            }else if(password.equals("")) {

                Toast.makeText(Login_Activity.this,"Coloque a password",Toast.LENGTH_SHORT).show();

            }else {

                String res = dp.ValidarLogin(email,password);

                if(res.equals("ok")){
                    Toast.makeText(Login_Activity.this,"Login efetuado com sucesso",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login_Activity.this,"Login não efetuado ",Toast.LENGTH_SHORT).show();
                }
            }

                Intent vai_pro_mapa = new Intent(Login_Activity.this, mapa_Activity.class);
                startActivity(vai_pro_mapa);

                finish();
            }
        });



    }
}
