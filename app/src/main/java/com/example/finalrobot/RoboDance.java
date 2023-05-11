package com.example.finalrobot;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.AnimateBuilder;
import com.aldebaran.qi.sdk.builder.AnimationBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.actuation.Animation;

public class RoboDance extends RobotActivity implements RobotLifecycleCallbacks {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


//        setContentView(R.layout.activity_main);
        QiSDK.register(this, (RobotLifecycleCallbacks) this);



    }
    @Override
    public void onRobotFocusGained(QiContext qiContext) {

        music = MediaPlayer.create(this, R.raw.song);
        music.start();

        Animation animation = AnimationBuilder.with(qiContext) // Create the builder with the context.
                .withResources(R.raw.dance_b004) // Set the animation resource.
                .build(); // Build the animation.

        //Create an animate action.
        Animate animate = AnimateBuilder.with(qiContext) // Create the builder with the context.
                .withAnimation(animation) // Set the animation.
                .build(); // Build the animate action.
        animate.run();

        Animation animation2 = AnimationBuilder.with(qiContext) // Create the builder with the context.
                .withResources(R.raw.walk_run_b001) // Set the animation resource.
                .build(); // Build the animation.

        //Create an animate action.
        Animate animate2 = AnimateBuilder.with(qiContext) // Create the builder with the context.
                .withAnimation(animation2) // Set the animation.
                .build(); // Build the animate action.
        animate2.run();
        animate2.run();


        music.stop();

    }

    @Override
    public void onRobotFocusLost() {

    }

    @Override
    public void onRobotFocusRefused(String reason) {

    }

    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks for this Activity.
        QiSDK.unregister(this, this);
        super.onDestroy();
    }

    private void animate(QiContext qiContext) {
        //Create an animation.
        Animation animation = AnimationBuilder.with(qiContext) // Create the builder with the context.
                .withResources(R.raw.dance_b004) // Set the animation resource.
                .build(); // Build the animation.

        //Create an animate action.
        Animate animate = AnimateBuilder.with(qiContext) // Create the builder with the context.
                .withAnimation(animation) // Set the animation.
                .build(); // Build the animate action.
        animate.run();
    }
}
