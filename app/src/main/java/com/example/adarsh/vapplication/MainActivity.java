package com.example.adarsh.vapplication;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;

import android.net.Uri;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    VideoView vidView =(VideoView) findViewById(R.id.myVideo);

    String VideoURL="https:/vzaar.com/videos/10738002" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the layout file to be displayed
        setContentView(R.layout.activity_main);

        // Find your VideoView in your video_main.xml layout

        // Execute StreamVideo AsyncTask

        // write some dialog so that i can debug easily
        pDialog = new ProgressDialog(MainActivity.this);
        // Set progressbar title
        pDialog.setTitle("Android Video Streaming Tutorial");
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();
        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(
                    MainActivity.this);
            mediacontroller.setAnchorView(vidView);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(VideoURL);
            vidView.setMediaController(mediacontroller);
            vidView.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        vidView.requestFocus();
        vidView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                vidView.start();
            }
        });

    }

}