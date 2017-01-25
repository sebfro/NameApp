package com.example.nameapp;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Debug;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static  int RESULT_LOAD_IMG = 1;
    private static int REQUEST_EXTERNAL_STORAGE = 0;
    private final String DEBUG_TAG = "Error";
    public static int images;
    private Uri imgUri;
    public static ArrayList<T> drawableArrayList = new ArrayList<T>();
    private ArrayList<String> nameArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = 0;


    }

    public void playGame(View view){
        Intent i = getIntent();
        Intent intent = new Intent(this, learningMode.class);
        startActivity(intent);
    }

    public void addImage(View view){

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.i(DEBUG_TAG, "Storage permission not granted. Requesting permissions.");
            String[] tmp = { Manifest.permission.READ_EXTERNAL_STORAGE };
            ActivityCompat.requestPermissions(MainActivity.this, tmp , REQUEST_EXTERNAL_STORAGE);



        } else {
            Log.i(DEBUG_TAG, "Storage permisson granted, opening album.");

            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, RESULT_LOAD_IMG);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int [] grantResults){
        if (requestCode == REQUEST_EXTERNAL_STORAGE){
            Log.d(DEBUG_TAG, "Received repsonse for contact permissions request.");

            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.d(DEBUG_TAG, "Permission granted.");
                Toast.makeText(this, "Permission granted.", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMG);

            } else {
                Log.d(DEBUG_TAG, "Permission denied.");
                Toast.makeText(this, " Permission denied.", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        // Check what the response is

        if (requestCode == RESULT_LOAD_IMG){
            //Check if successfull
            if(resultCode == RESULT_OK){
                //Toast.makeText(getApplicationContext(), data.toString(), Toast.LENGTH_LONG).show();
                imgUri = data.getData();
                try{
                    InputStream inputStream = getContentResolver().openInputStream(imgUri);
                    Drawable img = Drawable.createFromStream(inputStream, imgUri.toString());
                    T tmp = new T(img, "hei");
                    drawableArrayList.add(tmp);
                    Intent i = new Intent(this, EnterNameActivity.class);
                    startActivity(i);
                } catch(FileNotFoundException e){
                    Log.i(DEBUG_TAG, "File not found.");
                }

                /*uriArrayList.add(imgUri);
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imgUri);

                }catch(IOException e){
                    Toast.makeText(getApplicationContext(), "Something happend", Toast.LENGTH_LONG).show();
                }
                */
            }
        }
    }


    public void showList(View view){
        Intent i = new Intent(this, NameListActivity.class);
        startActivity(i);
    }

    public void quitApp(View view){

    }

    public void openGallery(View view){
        Intent i = new Intent(this, GalleryActivity.class);

        startActivity(i);
    }

    public class T {
        private Drawable d;
        private String name;
        public T (Drawable d, String name){
            this.d = d;
            this.name = name;
        }
        public Drawable getD(){
            return d;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }

    public static void addImage(){
        images++;
    }

}