package com.todo.sdm.sdm_android_todo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.todo.sdm.sdm_android_todo.R;

public class SplashActivity extends AppCompatActivity {

    Button tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Click with Henson
        tv = (Button) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(), HomeActivity.class);
                intent.putExtra("HOME_TITLE", "HELLO HOME ?");

                // Intent intent = HensonNavigator
                //         .gotoHomeActivity(context)
                //         .text("HELLO HOME ?")
                //         .build();

                startActivity(intent);
                finish();
            }
        });
    }

    // Click
    protected void click(View view) {

    }
}
