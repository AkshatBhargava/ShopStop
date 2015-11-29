package com.shop.mycart.shopstop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Akshat Bhargava on 11/23/2015.
 */
public class Splash extends Activity {

    private static String TAG = Splash.class.getName();
    private static long SLEEP_TIME = 5;    // Sleep for some time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar

        setContentView(R.layout.splash);


        //Rotating splash screen with fading effect in end.
            final ImageView iv = (ImageView) findViewById(R.id.imageView);
            final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
            final Animation an1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade);

            iv.startAnimation(an);
            an.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    iv.startAnimation(an1);
                    finish();

                    //Starting next activity.
                    IntentLauncher launcher = new IntentLauncher();
                    launcher.start();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        //
        /*// Start timer and launch main activity
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();*/
    }


    private class IntentLauncher extends Thread {
        @Override
        /**
         * Sleep for some time and than start new activity.
         */
        public void run() {
            /* //Code for delaying Activity start.
              try {
                // Sleeping
                Thread.sleep(SLEEP_TIME*1000);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }*/

            // Start main activity
//            Intent intent = new Intent(Splash.this, MainActivity.class);
            Intent intent = new Intent(Splash.this, LoginActivity.class);
            Splash.this.startActivity(intent);
            Splash.this.finish();
        }
    }
}
