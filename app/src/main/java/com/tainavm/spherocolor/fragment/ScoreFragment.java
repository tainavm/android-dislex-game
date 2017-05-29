package com.tainavm.spherocolor.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.orbotix.ConvenienceRobot;
import com.tainavm.spherocolor.R;

@SuppressLint("ValidFragment")
public class ScoreFragment extends Fragment {

    private ConvenienceRobot mRobot;

    @SuppressLint("ValidFragment")
    public ScoreFragment(ConvenienceRobot robot) {
        mRobot = robot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,    Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score,container,false);

        mRobot.drive(360,1);
        setSpheroColor(getResources().getColor(R.color.colorYellow));

        // Chama a tela com proxima questao
        Button btnNext = (Button) view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialog();
            }
        });

        // Chama a tela de voltar
        Button btnVoltar = (Button) view.findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Troca para o fragmento que inicia o jogo
                StartGameFragment startGameFragment = new StartGameFragment(mRobot);
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, startGameFragment)
                        .commit();
            }
        });

        return view;
    }

    public void setDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_message2)
                .setTitle(R.string.dialog_title2);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Seta a cor gerada na bolinha
     */
    public void setSpheroColor(int color) {
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        float red = r / 255f;
        float green = g / 255f;
        float blue = b / 255f;
        mRobot.setLed(red, green, blue);
    }


}
