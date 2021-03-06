/**
 * Computação Grafica - Puc Minas 2017
 * Tainá Viriato Mendes
 */

package com.tainavm.spherocolor.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tainavm.spherocolor.R;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        getSupportActionBar().setTitle("Como Jogar?");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Retorna para tela principal
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
