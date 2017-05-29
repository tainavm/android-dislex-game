/**
 * Computação Grafica - Puc Minas 2017
 * Tainá Viriato Mendes
 */

package com.tainavm.spherocolor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tainavm.spherocolor.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Tira o titulo da Action Bar
        getSupportActionBar().setElevation(0);
        getSupportActionBar().hide();

        // Chama a tela que conecta a Sphero quando clica
        Button btnPlay = (Button) findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, ConnectSpheroActivity.class);
                startActivity(intent);
            }
        });

        // Chama a tela de Tutorial quando clica
        Button btnTuto = (Button) findViewById(R.id.btnVoltar);
        btnTuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, TutorialActivity.class);
                startActivity(intent);
            }
        });
    }
}


