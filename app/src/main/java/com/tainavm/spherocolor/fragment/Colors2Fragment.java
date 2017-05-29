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
public class Colors2Fragment extends Fragment {

    private ConvenienceRobot mRobot;
    Button btnTextPink, btnTextPurple, btnTextBlue, btnTextRed, btnTextYellow, btnTextGreen, btnNext;
    int actualColor, lastColor = -1;
    boolean colorIsRight = false;

    public Colors2Fragment(ConvenienceRobot robot) {
        mRobot = robot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_colors2, container, false);

        // Gera uma cor aleatoria para a sphero
        changeSpheroColor();

        btnTextRed = (Button) view.findViewById(R.id.btnTextRed);
        btnTextRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorRed));
                if (colorIsRight) {
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);

                    // Muda para proxima questao
                    PortugueseFragment portugueseFragment = new PortugueseFragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, portugueseFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);
                    // Avisa o jogador que esta errado
                    setDialog();
                }
            }
        });

        btnTextBlue = (Button) view.findViewById(R.id.btnTextBlue);
        btnTextBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorBlue));
                if (colorIsRight) {
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);

                    // Muda para proxima questao
                    PortugueseFragment portugueseFragment = new PortugueseFragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, portugueseFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);
                    // Avisa o jogador que esta errado
                    setDialog();
                }
            }
        });

        btnTextGreen = (Button) view.findViewById(R.id.btnTextGreen);
        btnTextGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorGreen));
                if (colorIsRight) {
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);

                    // Muda para proxima questao
                    PortugueseFragment portugueseFragment = new PortugueseFragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, portugueseFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);
                    // Avisa o jogador que esta errado
                    setDialog();
                }
            }
        });

        btnTextPink = (Button) view.findViewById(R.id.btnTextPink);
        btnTextPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorPink));
                if (colorIsRight) {
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);

                    // Muda para proxima questao
                    PortugueseFragment portugueseFragment = new PortugueseFragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, portugueseFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);
                    // Avisa o jogador que esta errado
                    setDialog();
                }
            }
        });

        btnTextPurple = (Button) view.findViewById(R.id.btnTextPurple);
        btnTextPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorPurple));
                if (colorIsRight) {
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);

                    // Muda para proxima questao
                    PortugueseFragment portugueseFragment = new PortugueseFragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, portugueseFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);
                    // Avisa o jogador que esta errado
                    setDialog();
                }

            }
        });

        btnTextYellow = (Button) view.findViewById(R.id.btnTextYellow);
        btnTextYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorYellow));
                if (colorIsRight) {
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);

                    // Muda para proxima questao
                    PortugueseFragment portugueseFragment = new PortugueseFragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, portugueseFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 0);
                    // Avisa o jogador que esta errado
                    setDialog();
                }
            }
        });
//
//        btnNext = (Button) view.findViewById(R.id.btn_next);
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (colorIsRight) {
//                    // Coloca a bolinha verde
//                    setSpheroColor(getResources().getColor(R.color.colorGreen));
//                    // Faz a bolinha girar
//                    mRobot.drive(360, 0);
//
//                    // Muda para proxima questao
//                    PortugueseFragment portugueseFragment = new PortugueseFragment(mRobot);
//                    getFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.fragment_container, portugueseFragment)
//                            .addToBackStack(null)
//                            .commit();
//                } else {
//                    // Se estiver errado coloca a bolinha vermelha
//                    setSpheroColor(getResources().getColor(R.color.colorRed));
//                    // Faz a bolinha girar
//                    mRobot.drive(360, 0);
//                    // Avisa o jogador que esta errado
//                    setDialog();
//                }
//            }
//        });

        return view;
    }

    public void changeSpheroColor() {
        int num = 0;
        int color = 0;

        // Gera numero aleatorio
        num = (int) (Math.random() * 5);

        if (num == 0) {
            color = getResources().getColor(R.color.colorGreen);
        } else if (num == 1) {
            color = getResources().getColor(R.color.colorRed);
        } else if (num == 2) {
            color = getResources().getColor(R.color.colorBlue);
        } else if (num == 3) {
            color = getResources().getColor(R.color.colorPink);
        } else if (num == 4) {
            color = getResources().getColor(R.color.colorYellow);
        } else if (num == 5) {
            color = getResources().getColor(R.color.colorPurple);
        }

        actualColor = color;
        lastColor = num;
        setSpheroColor(color);

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

    public boolean verifyColor(int btnColor) {
        // if (enable) {
        if (actualColor == btnColor) {
            Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
            colorIsRight = true;
        } else {
            setDialog();
            colorIsRight = false;
        }
        // }
        return colorIsRight;
    }

    public void setDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
