package com.example.finalrobot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import androidx.appcompat.app.AppCompatActivity;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.AnimateBuilder;
import com.aldebaran.qi.sdk.builder.AnimationBuilder;
import com.aldebaran.qi.sdk.builder.SayBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.actuation.Animation;
import com.aldebaran.qi.sdk.object.conversation.Say;
import com.aldebaran.qi.sdk.object.locale.Language;
import com.aldebaran.qi.sdk.object.locale.Locale;
import com.aldebaran.qi.sdk.object.locale.Region;

public class Licenta extends RobotActivity implements RobotLifecycleCallbacks {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.licenta);
        Intent intent = getIntent();
        QiSDK.register(this, this);

        Button button = (Button) findViewById(R.id.skipToVideo);
        // Register the onClick listener with the implementation above
        button.setOnClickListener(mCorkyListener);

    }

    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks for this Activity.
        QiSDK.unregister(this, this);
        super.onDestroy();
    }


    @Override
    public void onRobotFocusGained(QiContext qiContext) {
        Say say = SayBuilder.with(qiContext) // Create the builder with the context.
                .withText("Robotics Robotics refers to the design, construction and operation of robots, as well as the development of systems that enable them to perform complex and autonomous tasks. The field of robotics involves knowledge from mechanical, electrical and computer engineering, and focuses on technologies such as sensors, actuators, controllers and artificial intelligence algorithms. The main goal of robotics is to develop intelligent equipment that is able to interact with the environment autonomously and efficiently. " +
                        "Automation Automation deals with the theory and applications of control systems, used to regulate and optimize the operation of industrial processes, vehicles, equipment and many other systems. Automation involves the mathematical analysis of control systems, as well as their design and implementation in various applications. The purpose of automation is to improve the efficiency, safety and productivity of systems by reducing human intervention and associated errors. " +
                        "Mechatronics is an interdisciplinary major that combines elements of mechanical, electrical, and computer engineering to design and build integrated and automated systems. Mechatronics deals with the integration of mechanical, electrical, electronic and control components into a single system with the aim of improving its performance and efficiency. Mechatronic systems are used in a variety of applications, from industrial machinery and automobiles to medical and consumer devices.")// Set the text to say.
                .build(); // Build the say action.

        say.run();

        Intent myIntent = new Intent(Licenta.this, VideoLicenta.class);
        //myIntent.putExtra("key", value); //Optional parameters
        Licenta.this.startActivity(myIntent);

    }

    @Override
    public void onRobotFocusLost() {

    }

    @Override
    public void onRobotFocusRefused(String reason) {

    }

    private View.OnClickListener mCorkyListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            Intent myIntent = new Intent(Licenta.this, VideoLicenta.class);
            //myIntent.putExtra("key", value); //Optional parameters
            Licenta.this.startActivity(myIntent);

        }
    };

}
