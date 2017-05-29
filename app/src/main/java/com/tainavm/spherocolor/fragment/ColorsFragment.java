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
public class ColorsFragment extends Fragment {

    Button btnNext, btnColorPink, btnColorRed, btnColorGreen, btnColorBlue, btnColorPurple, btnColorYellow;
    boolean enable = false;
    int actualColor, lastColor = -1;
    boolean colorIsRight = false;
    boolean textCorrect = false;
    EditText rightColor;
    private ConvenienceRobot mRobot;


    @SuppressLint("ValidFragment")
    public ColorsFragment(ConvenienceRobot robot) {
        mRobot = robot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colors, container, false);

        // Encontra o edit text
        rightColor = (EditText) view.findViewById(R.id.et_color);

        // Escolhe uma cor random para a bolinha
        changeSpheroColor();

        // Habilita os botões de cor
        enable = true;

        // Faz a verificacao da cor dos botoes
        btnColorBlue = (Button) view.findViewById(R.id.btn_colorBlue);
        btnColorBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorBlue));
                if (colorIsRight) {
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }
            }
        });

        btnColorGreen = (Button) view.findViewById(R.id.btn_colorGreen);
        btnColorGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorGreen));
                if (colorIsRight) {
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }

            }
        });

        btnColorPink = (Button) view.findViewById(R.id.btn_colorPink);
        btnColorPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorPink));
                if (colorIsRight) {
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }
            }
        });

        btnColorPurple = (Button) view.findViewById(R.id.btn_colorPurple);
        btnColorPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorPurple));
                if (colorIsRight) {
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }
            }
        });

        btnColorYellow = (Button) view.findViewById(R.id.btn_colorYellow);
        btnColorYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorYellow));
                if (colorIsRight) {
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }
            }
        });

        btnColorRed = (Button) view.findViewById(R.id.btn_colorRed);
        btnColorRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se a cor da bolinha e a cor do botao
                colorIsRight = verifyColor(getResources().getColor(R.color.colorRed));
                if (colorIsRight) {
                    Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                } else {
                    setDialog();
                }
            }
        });

        // Chama a tela com proxima questao se as respostas forem corretas
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se a cor selecionada for igual a da bolinha e o texto digitado estiver certo
                textCorrect = textIsCorret();
                if (colorIsRight && textCorrect) {
                    // Coloca a bolinha verde
                    setSpheroColor(getResources().getColor(R.color.colorGreen));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);
                    // Muda para a proxima questao
                    MathFragment mathFragment = new MathFragment(mRobot);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, mathFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Se estiver errado coloca a bolinha vermelha
                    setSpheroColor(getResources().getColor(R.color.colorRed));
                    // Faz a bolinha girar
                    mRobot.drive(360, 1);
                    setDialog();
                    // Avisa o jogador que esta errado
                    //  Toast.makeText(getContext(), "Errado! Tente novamente", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    /**
     * Verifica se a cor da bolinha é a cor pressionada no botão
     */
    public boolean verifyColor(int btnColor) {
        if (enable) {
            if (actualColor == btnColor) {
                Toast.makeText(getContext(), "Acertou", Toast.LENGTH_SHORT).show();
                colorIsRight = true;
            } else {
                Toast.makeText(getContext(), "Tente de novo", Toast.LENGTH_SHORT).show();
                colorIsRight = false;
            }
        }
        return colorIsRight;
    }

    /**
     * Gera uma cor aleatoria para a bolinha
     */
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

    /**
     * Verifica se o texto foi digitado corretamente
     */
    public boolean textIsCorret() {
        boolean textCorrect = false;
        String text = rightColor.getText().toString();
        if (text.equals("vermelho") || text.equals("Vermelho")) {
            textCorrect = true;
        }
        if (text.equals("azul") || text.equals("Azul")) {
            textCorrect = true;
        }
        if (text.equals("amarelo") || text.equals("Amarelo")) {
            textCorrect = true;
        }
        if (text.equals("verde") || text.equals("Verde")) {
            textCorrect = true;
        }
        if (text.equals("roxo") || text.equals("Roxo")) {
            textCorrect = true;
        }
        if (text.equals("rosa") || text.equals("Rosa")) {
            textCorrect = true;
        }

        return textCorrect;
    }

    public void setDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}

