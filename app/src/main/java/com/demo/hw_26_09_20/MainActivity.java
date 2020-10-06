package com.demo.hw_26_09_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);

        final Animation animation_set = AnimationUtils.loadAnimation(this, R.anim.animation_set);
        button.startAnimation(animation_set);

        final Button buttonTryAgain = (Button) findViewById(R.id.buttonTryAgain);
        buttonTryAgain.setVisibility(View.INVISIBLE);


        final View.OnClickListener clickListenerRestartGame = new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                button.setText("Click me!");
                button.startAnimation(animation_set);
                buttonTryAgain.setVisibility(View.INVISIBLE);
            }
        };

        final View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                button.setText("GOOD!!!");
                button.clearAnimation();
                buttonTryAgain.setVisibility(View.VISIBLE);
            }
        };

        button.setOnClickListener(clickListener);
        buttonTryAgain.setOnClickListener(clickListenerRestartGame);
    }
}