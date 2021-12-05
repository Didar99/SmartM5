package com.unity.tabletgorjav;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import io.github.controlwear.virtual.joystick.android.JoystickView;
import static com.unity.tabletgorjav.Commands.curtain_down;
import static com.unity.tabletgorjav.Commands.curtain_stop;
import static com.unity.tabletgorjav.Commands.curtain_up;

public class CurtainActivity extends Activity {
    ImageView c1, c2, c3, c4, c5, c6, ce;
    JoystickView joystick;
    boolean joystick_pos = false;
    int direction = 0;          // 0 -> stop, 1 -> up, 2 -> down
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curtain);
        // JoyStick (for control curtain UP AND DOWN)
        joystick = findViewById(R.id.joystickView);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        ce = findViewById(R.id.ce);

        joystick.setOnMoveListener((angle, strength) -> {
            System.out.println("angle is : " + angle); System.out.println("strength is : " + strength);
            // do whatever you want
            if (strength == 0) {
                direction = 0;
                joystick_pos = false;
                curtain_stop(getApplicationContext());
                System.out.println("stopped");
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.VISIBLE);
                ce.setVisibility(View.INVISIBLE);
                c4.setVisibility(View.INVISIBLE);
                c5.setVisibility(View.INVISIBLE);
                c6.setVisibility(View.INVISIBLE);

            }
            if (!joystick_pos) {
                if (angle == 90 && strength >= 70) {
                    direction = 1;
                    joystick_pos = true;
                    curtain_up(getApplicationContext());
                    System.out.println("up");
                }
            }
            if (!joystick_pos) {
                if (angle == 270 && strength >= 70) {
                    direction = 2;
                    joystick_pos = true;
                    curtain_down(getApplicationContext());
                    System.out.println("down");
                }
            }
            if (strength <= 30 && angle == 90) {
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.INVISIBLE);
                ce.setVisibility(View.INVISIBLE);
                c4.setVisibility(View.INVISIBLE);
                c5.setVisibility(View.INVISIBLE);
                c6.setVisibility(View.INVISIBLE);
            } else if (strength <= 70 && angle == 90) {
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.INVISIBLE);
                c3.setVisibility(View.INVISIBLE);
                ce.setVisibility(View.INVISIBLE);
                c4.setVisibility(View.INVISIBLE);
                c5.setVisibility(View.INVISIBLE);
                c6.setVisibility(View.INVISIBLE);
            } else if (strength <= 100 && angle == 90) {
                c1.setVisibility(View.INVISIBLE);
                c2.setVisibility(View.INVISIBLE);
                c3.setVisibility(View.INVISIBLE);
                ce.setVisibility(View.INVISIBLE);
                c4.setVisibility(View.INVISIBLE);
                c5.setVisibility(View.INVISIBLE);
                c6.setVisibility(View.INVISIBLE);
            } else if (strength <= 30 && angle == 270) {
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.VISIBLE);
                ce.setVisibility(View.VISIBLE);
                c4.setVisibility(View.VISIBLE);
                c5.setVisibility(View.INVISIBLE);
                c6.setVisibility(View.INVISIBLE);
            } else if (strength <= 70 && angle == 270) {
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.VISIBLE);
                ce.setVisibility(View.VISIBLE);
                c4.setVisibility(View.VISIBLE);
                c5.setVisibility(View.VISIBLE);
                c6.setVisibility(View.INVISIBLE);
            } else if (strength <= 100 && angle == 270) {
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.VISIBLE);
                ce.setVisibility(View.VISIBLE);
                c4.setVisibility(View.VISIBLE);
                c5.setVisibility(View.VISIBLE);
                c6.setVisibility(View.VISIBLE);
            }
        });
    }
}