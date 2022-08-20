package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    TextView mTextView;
    Button mButton;

    private static final String SHARED_PREFERENCES = "MY_SHARED_PREFERENCES";
    public static final String NAME_TAG = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.edit_text);
        mTextView = findViewById(R.id.text_view);
        mButton = findViewById(R.id.button);

        DisplaySavedText();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = mEditText.getText().toString();
                DisplayAndSave(enteredText);
            }
        });
    }

    private void DisplaySavedText() {
        //Retrieving the value from the SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

        String s1 = sharedPreferences.getString(NAME_TAG, " ");
        mTextView.setText(s1);
    }

    private void DisplayAndSave(String enteredText) {
        //Dispay the text
        mTextView.setText(enteredText);

        //saving the text into sharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

        //Writing data to shared pref
       SharedPreferences.Editor editor = sharedPreferences.edit();

       editor.putString(NAME_TAG, enteredText);
       editor.commit();
    }


}