package com.example.finalrobot;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;

import com.aldebaran.qi.sdk.QiRobot;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.QiChatbotBuilder;
import com.aldebaran.qi.sdk.builder.SayBuilder;
import com.aldebaran.qi.sdk.object.conversation.Phrase;
import com.aldebaran.qi.sdk.object.conversation.QiChatbot;
import com.aldebaran.qi.sdk.object.conversation.Say;
import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.object.conversation.SpeechEngine;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
//import com.softbankrobotics.dx.pepperlib.Robot;


public class MainActivity extends RobotActivity implements RobotLifecycleCallbacks {
//
//    private QiContext qiContext;
//    private QiChatbot chatbot;
//    private Say say;
//    private static QiRobot qiRobot;

    private static final int STORAGE_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button button = (Button) findViewById(R.id.Licenta);
        // Register the onClick listener with the implementation above
        button.setOnClickListener(mCorkyListener);

        Button button2 = (Button) findViewById(R.id.Master);
        // Register the onClick listener with the implementation above
        button2.setOnClickListener(mCorkyListener2);

        Button button3 = (Button) findViewById(R.id.Dance);
        // Register the onClick listener with the implementation above
        button3.setOnClickListener(mCorkyListener3);


        Button storage;
        storage = findViewById(R.id.storage);

        // Initialize the QiSDK
        QiSDK.register(this, (RobotLifecycleCallbacks) this);
    }

    //private QiContext qiContext = new QiContext(this);
//    public void Speak() {
//        Phrase phrase = new Phrase("Hello");
//        Say say = SayBuilder.with(qiContext).withPhrase(phrase).build();
//
//        say.run();
//
//    }

    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks for this Activity.
        QiSDK.unregister(this, this);
        super.onDestroy();
    }

    private View.OnClickListener mCorkyListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            Intent myIntent = new Intent(MainActivity.this, Licenta.class);
            //myIntent.putExtra("key", value); //Optional parameters
            MainActivity.this.startActivity(myIntent);

        }
    };

    private View.OnClickListener mCorkyListener2 = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            Intent myIntent = new Intent(MainActivity.this, MasterClass.class);
            //myIntent.putExtra("key", value); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        }
    };

    private View.OnClickListener mCorkyListener3 = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            Intent myIntent = new Intent(MainActivity.this, RoboDance.class);
            //myIntent.putExtra("key", value); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        }
    };


    @Override
    public void onRobotFocusGained(QiContext qiContext) {

        Say say = SayBuilder.with(qiContext) // Create the builder with the context.
                .withText("Hello human!") // Set the text to say.
                .build(); // Build the say action.

        say.run();

    }

    @Override
    public void onRobotFocusLost() {

    }

    @Override
    public void onRobotFocusRefused(String reason) {

    }

    public void checkPermission(String permission, int requestCode)
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}