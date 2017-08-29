package com.example.ajay.robotic_teaching;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView img_back_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        inIt();
    }

    private void inIt(){

        img_back_home = (ImageView)findViewById(R.id.img_back_home);
        img_back_home.setOnClickListener(this);
    }

    private void openAccount(){

        Intent i = new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.left, R.anim.right);
    }

    @Override
    public void onClick(View v) {
        if(v == img_back_home){
            openAccount();
        }
    }
}
