package com.lourdinas.appfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calcularmedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcularmedia);

        final EditText n1 = (EditText) findViewById(R.id.editText5);
        final EditText n2 = (EditText) findViewById(R.id.editText6);
        final EditText n3 = (EditText) findViewById(R.id.editText7);
        final EditText n4 = (EditText) findViewById(R.id.editText8);
        final TextView resultado = (TextView) findViewById(R.id.editText9);
        Button calcular= (Button) findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valor1= Double.parseDouble(n1.getText().toString());
                double valor2= Double.parseDouble(n2.getText().toString());
                double valor3= Double.parseDouble(n3.getText().toString());
                double valor4= Double.parseDouble(n4.getText().toString());

                double media=(valor1+valor2+valor3+valor4)/4;
                String result=Double.toString(media);
                resultado.setText(result);
            }
        });

    }
}
