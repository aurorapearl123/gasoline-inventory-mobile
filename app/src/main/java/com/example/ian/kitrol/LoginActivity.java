package com.example.ian.kitrol;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editTextPin;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextPin = (EditText) this.findViewById(R.id.id_pin);
        btn_login = (Button) this.findViewById(R.id.id_btn_login);
//        Drawable x = getResources().getDrawable(R.drawable.cancel);
//        x.setBounds(0, 0, x.getIntrinsicWidth(), x.getIntrinsicHeight());
//        editTextPin.setCompoundDrawables(null, null, x, null);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });

    }

    public void goToMain()
    {
        startActivity(new Intent(this, MainActivity.class));
    }
}
