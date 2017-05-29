/**
 * Computação Grafica - Puc Minas 2017
 * Tainá Viriato Mendes
 */

package com.tainavm.spherocolor.activity;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
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
    //   private ConvenienceRobot _connectedRobot;
    // private DiscoveryAgent _currentDiscoveryAgent;
    private LinearLayout layLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
//        _currentDiscoveryAgent = DiscoveryAgentClassic.getInstance();
//        startDiscovery();

        connect.getInstance().addRobotStateListener(this);
        layLoading = (LinearLayout) findViewById(R.id.layLoading);


    }

    //    @Override
//    public void handleRobotsAvailable(List<Robot> list) {
//        if (_currentDiscoveryAgent instanceof DiscoveryAgentClassic) {
//            // If we are using the classic discovery agent, and therefore using Sphero, we'll just connect to the first
//            // one available that we get. Note that "available" in classic means paired to the phone and turned on.
//            _currentDiscoveryAgent.connect(list.get(0));
//        }
//    }
//
//    @Override
//    public void handleRobotChangedState(Robot robot, RobotChangedStateNotificationType robotChangedStateNotificationType) {
//        switch (robotChangedStateNotificationType) {
//            // A robot was connected, and is ready for you to send commands to it.
//            case Online:
//                // When a robot is connected, this is a good time to stop discovery. Discovery takes a lot of system
//                // resources, and if left running, will cause your app to eat the user's battery up, and may cause
//                // your application to run slowly. To do this, use DiscoveryAgent#stopDiscovery().
//                _currentDiscoveryAgent.stopDiscovery();
//                // It is also proper form to not allow yourself to re-register for the discovery listeners, so let's
//                // unregister for the available notifications here using DiscoveryAgent#removeDiscoveryListener().
//                _currentDiscoveryAgent.removeDiscoveryListener(this);
//                // Don't forget to turn on UI elements
//
//                // Depending on what was connected, you might want to create a wrapper that allows you to do some
//                // common functionality related to the individual robots. You can always of course use the
//                // Robot#sendCommand() method, but Ollie#drive() reads a bit better.
//                _connectedRobot = new Sphero(robot);
//
//                Log.d("OK", "Sphero conectado");
//
//                _connectedRobot.setZeroHeading();
//
//                startGame();
//
//                break;
//            case Disconnected:
//                Log.d("DESCONECTADO", "Sphero foi desconectado");
//                break;
//            default:
//                Log.v("ERRO", "Not handling state change notification: " + robotChangedStateNotificationType);
//                break;
//        }
//    }
    @Override
    public void handleRobotChangedState(Robot robot, RobotChangedStateNotificationType type) {
        switch (type) {
            case Online: {
                if (findViewById(R.id.fragment_container) != null) {
                    connect.getInstance().stopDiscovery();
                    Toast.makeText(ConnectSpheroActivity.this, "Sphero Conectada", Toast.LENGTH_SHORT).show();
                    mRobot = new ConvenienceRobot(robot);
                    layLoading.setVisibility(View.GONE);
                    //     mRobot.setZeroHeading();

                    // Troca para o fragmento que inicia o jogo
                    StartGameFragment startGameFragment = new StartGameFragment(mRobot);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container, startGameFragment)
                            .commit();


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

    @Override
    protected void onStart() {
        super.onStart();
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {
                        //If the DiscoveryAgent is not already looking for robots, start discovery.
                        if (!connect.getInstance().isDiscovering()) {
                            try {
                                connect.getInstance().startDiscovery(getApplicationContext());
                            } catch (DiscoveryException e) {
                                Log.e("Sphero", "DiscoveryException: " + e.getMessage());
                            }
                        }
                    }
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */}
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */}
                }).check();


    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        // This line assumes that this object is a Context
//        try {
//            DualStackDiscoveryAgent.getInstance().startDiscovery(this);
//        } catch( DiscoveryException e ) {
//            //handle exception
//        }
//
//    }
//
//    @Override
//    protected void onStop() {
//        //If the DiscoveryAgent is in discovery mode, stop it.
//        if (DualStackDiscoveryAgent.getInstance().isDiscovering()) {
//            DualStackDiscoveryAgent.getInstance().stopDiscovery();
//        }
//
//        //If a robot is connected to the device, disconnect it
//        if (mRobot != null) {
//            mRobot.disconnect();
//            mRobot = null;
//        }
//        super.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        DualStackDiscoveryAgent.getInstance().addRobotStateListener(null);
//    }
//
//    private void startDiscovery() {
//        try {
//            // You first need to set up so that the discovery agent will notify you when it finds robots.
//            // To do this, you need to implement the DiscoveryAgentEventListener interface (or declare
//            // it anonymously) and then register it on the discovery agent with DiscoveryAgent#addDiscoveryListener()
//            _currentDiscoveryAgent.addDiscoveryListener(this);
//            // Second, you need to make sure that you are notified when a robot changes state. To do this,
//            // implement RobotChangedStateListener (or declare it anonymously) and use
//            // DiscoveryAgent#addRobotStateListener()
//            _currentDiscoveryAgent.addRobotStateListener(this);
//            // Then to start looking for a Sphero, you use DiscoveryAgent#startDiscovery()
//            // You do need to handle the discovery exception. This can occur in cases where the user has
//            // Bluetooth off, or when the discovery cannot be started for some other reason.
//            _currentDiscoveryAgent.startDiscovery(this);
//
//            Log.d("ACHOU", "Encontrado sphero");
//        } catch (DiscoveryException e) {
//            Log.e("ERRO", "Could not start discovery. Reason: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }


}
