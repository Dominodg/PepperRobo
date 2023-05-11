package com.example.finalrobot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.SayBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.conversation.Say;

import android.widget.MediaController;


public class Master extends RobotActivity implements RobotLifecycleCallbacks {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master);
        Intent intent = getIntent();

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.videoclip);

        MediaController mediaController = new MediaController(this);
        //link mediaController to videoView
        mediaController.setAnchorView(videoView);
        //allow mediaController to control our videoView
        videoView.setMediaController(mediaController);
        videoView.start();

    }

    @Override
    public void onRobotFocusGained(QiContext qiContext) {
        Say say = SayBuilder.with(qiContext) // Create the builder with the context.
                .withText("Are you tired of the same old career options? Want to make a difference in the world while having a blast? Look no further than Robotics! Our program at the Technical University of Cluj-Napoca offers cutting-edge training in programming, AI, control, sensing, design, and integration of robotic systems. Plus, with a degree in Robotics, you'll be ready for exciting and diverse career paths, like designing robots for healthcare, transportation, or even space exploration! And let's be honest, who wouldn't want to build a robot that can go to space? So, join the digital revolution and shape the future with us at Robotics. Check out our website at www.utcn-robotica.ro for more information!")// Set the text to say.
                .build(); // Build the say action.

        say.run();

    }

    @Override
    public void onRobotFocusLost() {

    }

    @Override
    public void onRobotFocusRefused(String reason) {

    }
}
