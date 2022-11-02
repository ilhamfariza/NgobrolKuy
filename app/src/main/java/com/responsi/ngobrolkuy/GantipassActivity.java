package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GantipassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gantipass);
    }

    public void pindahpass(View view) {
        Intent intent = new Intent(GantipassActivity.this, PassActivity.class);
        startActivity(intent);
    }
}