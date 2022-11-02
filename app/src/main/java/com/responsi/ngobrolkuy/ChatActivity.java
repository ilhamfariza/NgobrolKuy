package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    public void pindahset(View view) {
        Intent intent = new Intent(ChatActivity.this, GantipassActivity.class);
        startActivity(intent);
    }

    public void handleLogin(View view) {
        Intent intent = new Intent(ChatActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}