package com.example.gustavotavaresetimpamigravarelerdadoscomsharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnGravar, btnRecuperar;
    EditText edtNome, edtTelefone, edtIdade;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGravar    = findViewById(R.id.btnGravar);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        edtNome      = findViewById(R.id.edtNome);
        edtTelefone  = findViewById(R.id.edtTelefone);
        edtIdade     = findViewById(R.id.edtIdade);
        tvInfo       = findViewById(R.id.tvInfo);

        edtNome.requestFocus();

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("chaveGeral", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("chaveNome",     edtNome.getText().toString());
                editor.putString("chaveTelefone", edtTelefone.getText().toString());
                editor.putString("chaveIdade",    edtIdade.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this, "Gravado com Sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("chaveGeral", MODE_PRIVATE);
                String nome     = prefs.getString("chaveNome", "");
                String telefone = prefs.getString("chaveTelefone", "");
                String idade    = prefs.getString("chaveIdade", "");

                tvInfo.setText(
                        "Nome: " + nome + "\n" +
                                "Telefone: " + telefone + "\n" +
                                "Idade: " + idade
                );
            }
        });
    }
}