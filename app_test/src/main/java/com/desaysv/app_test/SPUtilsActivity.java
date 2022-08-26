package com.desaysv.app_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.desaysv.lib_base.utils.SPUtils;

public class SPUtilsActivity extends AppCompatActivity {

    public final String TestView = "results_text_view";
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.results_text_view);
    }
}