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
public class MathFragment extends Fragment {

    private ConvenienceRobot mRobot;

    @SuppressLint("ValidFragment")
    public MathFragment(ConvenienceRobot robot) {
        mRobot = robot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_math,container,false);

        // TODO FAZER LOGICA DAS RESPOSTAS CORRETAS
        // TODO GERAR EXPRESSOES ALEATORIAS

        // Chama a tela com proxima questao
        Button btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Muda para proxima questao
                MemoryFragment memoryFragment = new MemoryFragment(mRobot);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, memoryFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }

}
