/**
 * Computação Grafica - Puc Minas 2017
 * Tainá Viriato Mendes
 */

package com.tainavm.spherocolor.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.orbotix.ConvenienceRobot;
import com.tainavm.spherocolor.R;

@SuppressLint("ValidFragment")
public class StartGameFragment extends Fragment {

    private ConvenienceRobot mRobot;
    public Button btnStart;

    @SuppressLint("ValidFragment")
    public StartGameFragment(ConvenienceRobot robot) {
        mRobot = robot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_game, container, false);

        btnStart = (Button) view.findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Troca para o fragmento de cores
                ColorsFragment colorsFragment = new ColorsFragment(mRobot);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, colorsFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });

        return view;
    }

}
