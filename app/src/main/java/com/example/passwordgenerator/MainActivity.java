package com.example.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    Button copy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(generateString(12));
                copy = findViewById(R.id.copy);
                copy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("password text", textView.getText().toString());
                        clipboard.setPrimaryClip(clip);
                        Toast toast = Toast.makeText(getApplicationContext(), "Copied to clipboard", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        });
    }
    private String generateString(int length){
        char[] chars ="QWERTYUIOPASDFGHJKLZXCVBNMmnbvcxzlkjhgfsapoiuytrewq1234567890!@#$%^&*()".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for ( int i= 0; i<length;i++)
        {
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);

        }
        return stringBuilder.toString();
    }
}