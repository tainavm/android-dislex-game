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
import android.widget.ImageView;
import android.widget.Toast;

import com.orbotix.ConvenienceRobot;
import com.tainavm.spherocolor.R;

@SuppressLint("ValidFragment")
public class DriveFragment extends Fragment {

    private ConvenienceRobot mRobot;
    ImageView btnLeft, btnRight, btnUp, btnDown;
    boolean isCorrect = false;

    @SuppressLint("ValidFragment")
    public DriveFragment(ConvenienceRobot robot) {
        mRobot = robot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drive, container, false);

        btnLeft = (ImageView) view.findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCorrect = false;
                setDialog();
                mRobot.drive(270, 2);
            }
        });

        btnDown = (ImageView) view.findViewById(R.id.btnDown);
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCorrect = false;
                setDialog();
                mRobot.drive(180, 2);
            }
        });

        btnRight = (ImageView) view.findViewById(R.id.btnRight);
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCorrect = true;
                Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                mRobot.drive(90, 2);
            }
        });

        btnUp = (ImageView) view.findViewById(R.id.btnUp);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCorrect = false;
                setDialog();
                mRobot.drive(0, 2);
            }
        });

        // Chama a tela com proxima questao
        Button btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCorrect) {
                    // Se estiver errado coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);
                    // Muda para proxima questao
                    ScoreFragment scoreFragment = new ScoreFragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, scoreFragment)
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);
        AlertDialog dialog = builder.create();
    }


}
