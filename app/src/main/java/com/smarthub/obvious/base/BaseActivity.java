package com.smarthub.obvious.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Base Activity for handling all common functions ,
 * processes those are might be use generally in every of recursively
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseSetup();
    }

    void baseSetup(){

    }
}
