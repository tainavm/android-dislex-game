/**
 * Computação Grafica - Puc Minas 2017
 * Tainá Viriato Mendes
 */

package com.tainavm.spherocolor.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.orbotix.ConvenienceRobot;
import com.orbotix.DualStackDiscoveryAgent;
import com.orbotix.common.DiscoveryException;
import com.orbotix.common.Robot;
import com.orbotix.common.RobotChangedStateListener;
import com.tainavm.spherocolor.R;

@SuppressLint("ValidFragment")
public class StartGameFragment extends Fragment implements RobotChangedStateListener {

    public DualStackDiscoveryAgent coneccao;
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

    @Override
    public void handleRobotChangedState(Robot robot, RobotChangedStateNotificationType type) {
        switch (type) {
            case Online: {
                //Save the robot as a ConvenienceRobot for additional utility methods
                mRobot = new ConvenienceRobot( robot );

                //Create an OrbBasicControl for loading programs onto the robot
//                mOrbBasicControl = new OrbBasicControl( robot );
//                mOrbBasicControl.addEventListener((OrbBasicEventListener) this);
                Log.d("OK", "Sphero conectado");
                Toast.makeText(getContext(), "Sphero conectado!", Toast.LENGTH_SHORT).show();
                int color = getResources().getColor(R.color.colorGreen);
                int r = Color.red(color);
                int g = Color.green(color);
                int b = Color.blue(color);
                float red = r/255f;
                float green = g/255f;
                float blue = b/255f;

                String cor = "CORE " + red + " " + green + " " + blue;
                Log.d("COREEEEES", cor);

//                mRobot.setLed(0.0f, 0.0f, 1.0f);
                mRobot.setLed(red,green,blue);
                break;
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        //If the DiscoveryAgent is not already looking for robots, start discovery.
        if( !coneccao.getInstance().isDiscovering() ) {
            try {
                coneccao.getInstance().startDiscovery(getContext());
            } catch (DiscoveryException e) {
                Log.e("Sphero", "DiscoveryException: " + e.getMessage());
            }
        }
    }

}
