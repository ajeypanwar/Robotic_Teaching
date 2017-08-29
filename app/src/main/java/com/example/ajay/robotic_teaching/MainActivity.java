package com.example.ajay.robotic_teaching;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ajay.robotic_teaching.Adapter.GridAdapter;
import com.example.ajay.robotic_teaching.Model.GridModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView grid_recycler_view;
    private GridAdapter grid_Adapter;
    private List<GridModel> grid_data;

    private TextView mTextMessage;
    private ImageView img_account;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    Fragment fragment1 = new HomeFragment();
                    // MainActivity.this.overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                    android.support.v4.app.FragmentTransaction fragmentTransactionPrayasHome1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionPrayasHome1.replace(R.id.fram, fragment1);
                    fragmentTransactionPrayasHome1.commit();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    Fragment fragment = new GridFragment();
                    // MainActivity.this.overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                    android.support.v4.app.FragmentTransaction fragmentTransactionPrayasHome = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionPrayasHome.replace(R.id.fram, fragment);
                    fragmentTransactionPrayasHome.commit();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    Fragment fragment2 = new VerticalFragment();
                    // MainActivity.this.overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                    android.support.v4.app.FragmentTransaction fragmentTransactionPrayasHome2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionPrayasHome2.replace(R.id.fram, fragment2);
                    fragmentTransactionPrayasHome2.commit();
                    return true;
                case R.id.navigation_notification:
                    mTextMessage.setText(R.string.title_notifications);
                    Fragment fragment3 = new ListFragment();
                    // MainActivity.this.overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                    android.support.v4.app.FragmentTransaction fragmentTransactionPrayasHome3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionPrayasHome3.replace(R.id.fram, fragment3);
                    fragmentTransactionPrayasHome3.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inIt();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            Fragment fragment = new HomeFragment();
            // MainActivity.this.overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
            android.support.v4.app.FragmentTransaction fragmentTransactionPrayasHome = getSupportFragmentManager().beginTransaction();
            fragmentTransactionPrayasHome.replace(R.id.fram, fragment);
            fragmentTransactionPrayasHome.commit();
        }
    }

    private void inIt(){

        mTextMessage = (TextView) findViewById(R.id.message);
        img_account = (ImageView)findViewById(R.id.img_account);
        img_account.setOnClickListener(this);
    }

    private void openAccount(){

        Intent i = new Intent(getBaseContext(), AccountActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.left, R.anim.right);
    }

    @Override
    public void onClick(View v) {
        if(v == img_account){
            openAccount();
        }

       /* if(v == buttonView){
            startActivity(new Intent(this,ViewEmp.class));
        }*/
    }
}
