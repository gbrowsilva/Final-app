package com.lourdinas.appfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro extends AppCompatActivity {

    SharedPreferences meusDados;
    public static final String mypreference = "call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        meusDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        Button cadastrar = (Button) findViewById(R.id.btn_cadastrar);
        final EditText novoidade = (EditText)findViewById(R.id.edit_idade);
        final EditText novonome = (EditText)findViewById(R.id.edit_nome);
        final EditText novonascimento = (EditText)findViewById(R.id.edit_nascimento);
        final EditText novoEmail = (EditText)findViewById(R.id.edt_email1);
        final EditText novaSenha = (EditText) findViewById(R.id.edt_novaSenha);
        final EditText confirmaSenha = (EditText) findViewById(R.id.edt_confirmaSenha);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaSenha.getText().toString().equals(confirmaSenha.getText().toString())) {

                    SharedPreferences.Editor editor = meusDados.edit();
                    editor.putString("email" , novoEmail.getText().toString());
                    editor.putString("senha", novaSenha.getText().toString());
                    editor.putString("idade", novoidade.getText().toString());
                    editor.putString("nome", novonome.getText().toString());
                    editor.putString("nascimento", novonascimento.getText().toString());
                    editor.commit();

                    Toast.makeText(getApplicationContext(),
                            "Dados salvos com sucesso", Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(cadastro.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "As senhas não conferem", Toast.LENGTH_LONG);
                }
            }
        });

    }


}
