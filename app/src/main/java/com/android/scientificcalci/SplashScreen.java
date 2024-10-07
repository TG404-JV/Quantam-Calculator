package com.android.scientificcalci;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_DURATION = 5000; // Splash screen duration in milliseconds

    private AppCompatImageView logoImage;
    private TextView appNameTextView;
    private TextView devTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Initialize views
        logoImage = findViewById(R.id.logo_image);
        appNameTextView = findViewById(R.id.app_name);
        devTextView = findViewById(R.id.dev);

        // Apply animations
        Animation logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        logoImage.startAnimation(logoAnimation);

        Animation appNameAnimation = AnimationUtils.loadAnimation(this, R.anim.app_name_animation);
        appNameTextView.startAnimation(appNameAnimation);

        Animation devAnimation = AnimationUtils.loadAnimation(this, R.anim.dev_animation);
        devTextView.startAnimation(devAnimation);

        // Start main activity after splash screen duration
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, Calculator.class);
            startActivity(intent);
            finish();
        }, SPLASH_DURATION);
    }
}
