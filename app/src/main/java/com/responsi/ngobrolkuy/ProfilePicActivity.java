package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePicActivity extends AppCompatActivity {

    private CircleImageView profilePic;
    private Button input;
    private static final String TAG = ProfilePicActivity.class.getCanonicalName();
    private static final int GALERRY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);
        profilePic = findViewById(R.id.profilePic);
        input = findViewById(R.id.uploadbtn);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALERRY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Gagal Input Gambar", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(requestCode == GALERRY_REQUEST_CODE){
            if(data != null){
                try{
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    profilePic.setImageBitmap(bitmap);
                }
                catch (IOException e){
                    Toast.makeText(this, "Tidak dapat memuat gambar", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

    public void pindahroom(View view) {
        Intent intent = new Intent(ProfilePicActivity.this, ChatActivity.class);
        startActivity(intent);
    }
}