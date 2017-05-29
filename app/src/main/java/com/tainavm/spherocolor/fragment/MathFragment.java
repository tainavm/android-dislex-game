/**
 * Computação Grafica - Puc Minas 2017
 * Tainá Viriato Mendes
 */

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
import android.widget.Toast;

import com.orbotix.ConvenienceRobot;
import com.tainavm.spherocolor.R;

@SuppressLint("ValidFragment")
public class MathFragment extends Fragment {

    private ConvenienceRobot mRobot;
    Button btnResp1, btnResp2, btnResp3, btnResp4;
    boolean correct = false;

    @SuppressLint("ValidFragment")
    public MathFragment(ConvenienceRobot robot) {
        mRobot = robot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_math, container, false);

        btnResp1 = (Button) view.findViewById(R.id.btnResp1);
        btnResp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guarda resposta correta;
                if (btnResp1.getText().toString().equals("43")) {
                    correct = true;
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);
                    // Avisa o jogador que esta errado
                    setDialog();
                    //  Toast.makeText(getContext(), "Errado! Tente novamente", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnResp2 = (Button) view.findViewById(R.id.btnResp2);
        btnResp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guarda resposta correta;
                if (btnResp2.getText().toString().equals("43")) {
                    correct = true;
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);

                    // Muda para proxima questao
                    Colors2Fragment colors2Fragment = new Colors2Fragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, colors2Fragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);
                    // Avisa o jogador que esta errado
                    setDialog();
                    //  Toast.makeText(getContext(), "Errado! Tente novamente", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnResp3 = (Button) view.findViewById(R.id.btnResp3);
        btnResp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guarda resposta correta;
                if (btnResp3.getText().toString().equals("43")) {
                    correct = true;
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);

                    // Muda para proxima questao
                    Colors2Fragment colors2Fragment = new Colors2Fragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, colors2Fragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);
                    // Avisa o jogador que esta errado
                    setDialog();
                    //  Toast.makeText(getContext(), "Errado! Tente novamente", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnResp4 = (Button) view.findViewById(R.id.btnResp4);
        btnResp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guarda resposta correta;
                if (btnResp4.getText().toString().equals("43")) {
                    correct = true;
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);

                    // Muda para proxima questao
                    Colors2Fragment colors2Fragment = new Colors2Fragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, colors2Fragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);
                    // Avisa o jogador que esta errado
                    setDialog();
                    //  Toast.makeText(getContext(), "Errado! Tente novamente", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
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

    public void setDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
