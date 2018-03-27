package com.todo.sdm.sdm_android_todo.activitys;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.todo.sdm.sdm_android_todo.R;
import com.todo.sdm.sdm_android_todo.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // [#] Layout CamelCase
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        // [V]
        binding.setA(this);

        // Dart.inject(this);

    }

    public void makeToast(View view){
        Toast.makeText(this,"I'm Home !",Toast.LENGTH_SHORT).show();
    }

}
