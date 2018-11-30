package com.lourdinas.appfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class telainicial extends AppCompatActivity {

    SharedPreferences meusDados;
    public static final String mypreference = "call";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telainicial);

        meusDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        final EditText edtEmail = (EditText)findViewById(R.id.edt_email);
        final EditText edtSenha = (EditText) findViewById(R.id.edt_senha);
        TextView registro = (TextView) findViewById(R.id.tnt_registro);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String meusEmail = edtEmail.getText().toString();
                String minhaSenha = edtSenha.getText().toString();

                if (meusDados.contains("email") && meusDados.contains("senha")) {

                    if (meusEmail.equals(meusDados.getString("email", ""))
                            && minhaSenha.equals(meusDados.getString("senha", ""))) {
                        Intent intent = new Intent(telainicial.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Email ou senha invalida!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Não existem cadastro!", Toast.LENGTH_LONG).show();
                }
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(telainicial.this, cadastro.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

