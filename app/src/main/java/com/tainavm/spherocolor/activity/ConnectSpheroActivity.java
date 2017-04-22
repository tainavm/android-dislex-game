/**
 * Computação Grafica - Puc Minas 2017
 * Tainá Viriato Mendes
 */

package com.tainavm.spherocolor.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.orbotix.ConvenienceRobot;
import com.orbotix.DualStackDiscoveryAgent;
import com.orbotix.common.DiscoveryException;
import com.orbotix.common.Robot;
import com.orbotix.common.RobotChangedStateListener;
import com.tainavm.spherocolor.R;
import com.tainavm.spherocolor.fragment.StartGameFragment;

/**
 * Responsavel pela conexao com a Sphero
 */
public class ConnectSpheroActivity extends AppCompatActivity implements RobotChangedStateListener {

//    public class ConnectSpheroActivity extends AppCompatActivity {
    public DualStackDiscoveryAgent connect;
    private ConvenienceRobot mRobot;
    private LinearLayout layLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

       connect.getInstance().addRobotStateListener(this);
        layLoading = (LinearLayout) findViewById(R.id.layLoading);

    }

    @Override
    protected void onStart() {
        super.onStart();

        //If the DiscoveryAgent is not already looking for robots, start discovery.
        if (!connect.getInstance().isDiscovering()) {
            try {
                connect.getInstance().startDiscovery(getApplicationContext());
            } catch (DiscoveryException e) {
                Log.e("Sphero", "DiscoveryException: " + e.getMessage());
            }
        }
    }

    @Override
    public void handleRobotChangedState(Robot robot, RobotChangedStateNotificationType type) {
        switch (type) {
            case Online: {
                if (findViewById(R.id.fragment_container) != null) {
                    mRobot = new ConvenienceRobot(robot);
                    layLoading.setVisibility(View.GONE);

                    // Troca para o fragmento que inicia o jogo
                    StartGameFragment startGameFragment = new StartGameFragment(mRobot);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container, startGameFragment)
                            .commit();

                    Toast.makeText(ConnectSpheroActivity.this, "Sphero Conectada", Toast.LENGTH_SHORT).show();

                    int color = getResources().getColor(R.color.colorGreen);
                    int r = Color.red(color);
                    int g = Color.green(color);
                    int b = Color.blue(color);
                    float red = r / 255f;
                    float green = g / 255f;
                    float blue = b / 255f;
                    mRobot.setLed(red, green, blue);
                }
                break;
            }
            case FailedConnect: {
                //If the DiscoveryAgent is not already looking for robots, start discovery.
                if (!connect.getInstance().isDiscovering()) {
                    try {
                        connect.getInstance().startDiscovery(getApplicationContext());
                        Toast.makeText(ConnectSpheroActivity.this, "Não foi possivel conectar1", Toast.LENGTH_SHORT).show();
                    } catch (DiscoveryException e) {
                        Toast.makeText(ConnectSpheroActivity.this, "Não foi possivel conectar", Toast.LENGTH_SHORT).show();
                        Log.e("Sphero", "DiscoveryException: " + e.getMessage());
                    }
                }
            }
        }
    }


}
