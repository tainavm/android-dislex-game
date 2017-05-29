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
import android.widget.EditText;
import android.widget.Toast;

import com.orbotix.ConvenienceRobot;
import com.tainavm.spherocolor.R;

@SuppressLint("ValidFragment")
public class PortugueseFragment extends Fragment {

    private ConvenienceRobot mRobot;
    Button btnQuest1, btnQuest3, btnQuest2, btnQuest4, btnNext;
    boolean isCorrect = false;
    boolean textCorrect = false;
    EditText rightText;

    @SuppressLint("ValidFragment")
    public PortugueseFragment(ConvenienceRobot robot) {
        mRobot = robot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_portuguese, container, false);

        // Encontra o edit text
        rightText = (EditText) view.findViewById(R.id.rightText);

        btnQuest1 = (Button) view.findViewById(R.id.btnQues1);
        btnQuest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnQuest1.getText().toString().equals("Polvu")) {
                    isCorrect = true;
                    Toast.makeText(getContext(),"Acertou",Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }

            }
        });

        btnQuest2 = (Button) view.findViewById(R.id.btnQues2);
        btnQuest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnQuest2.getText().toString().equals("Polvu")) {
                    isCorrect = true;
                    Toast.makeText(getContext(),"Acertou",Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }
            }
        });

        btnQuest3 = (Button) view.findViewById(R.id.btnQues3);
        btnQuest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnQuest3.getText().toString().equals("Polvu")) {
                    isCorrect = true;
                    Toast.makeText(getContext(),"Acertou",Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }
            }
        });

        btnQuest4 = (Button) view.findViewById(R.id.btnQues4);
        btnQuest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnQuest4.getText().toString().equals("Polvu")) {
                    isCorrect = true;
                    Toast.makeText(getContext(),"Acertou",Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }

            }
        });

        // Chama a tela com proxima questao
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCorrect = textIsCorrect();
                if (isCorrect && textCorrect) {
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));

                    // Faz a bolinha girar
                    mRobot.drive(360, 1);

                    Toast.makeText(getContext(),"Acertou",Toast.LENGTH_SHORT).show();

                    // Muda para proxima questao
                    DriveFragment driveFragment = new DriveFragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, driveFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);
                    // Avisa o jogador que esta errado
                    setDialog();

                }
            }
        });


        return view;
    }

    public boolean textIsCorrect() {
        boolean textCorrect = false;
        String text = rightText.getText().toString();
        if (text.equals("polvo") || text.equals("Polvo")) {
            textCorrect = true;
        }
        return textCorrect;
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
