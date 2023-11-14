package com.rafsan.class219texttovoice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myString = editText.getText().toString();
                if(myString.length() >0){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        textToSpeech.speak(""+myString, TextToSpeech.QUEUE_FLUSH,null,null);
                    }
                }
                else {
                    editText.setError("Please,Enter any TEXT");
                    Toast.makeText(MainActivity.this,"দয়া করে কিছু লেখ",Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}