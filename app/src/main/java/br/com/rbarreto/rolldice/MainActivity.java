package br.com.rbarreto.rolldice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.dice1);
        imageView2 = findViewById(R.id.dice2);
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;

    }

    public void rollDice(View v){

        final Animation anim1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
        final Animation anim2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
        final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                int value = randomDiceValue();
                int res = getResources().getIdentifier("dice" + value, "drawable", "br.com.rbarreto.rolldice");

                if (animation == anim1) {
                    imageView1.setImageResource(res);
                } else if (animation == anim2) {
                    imageView2.setImageResource(res);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        anim1.setAnimationListener(animationListener);
        anim2.setAnimationListener(animationListener);

        imageView1.startAnimation(anim1);
        imageView2.startAnimation(anim2);

    }
}
