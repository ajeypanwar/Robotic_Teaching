package com.example.ajay.robotic_teaching;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ajay.robotic_teaching.Adapter.AutoImageAdapter;
import com.example.ajay.robotic_teaching.Adapter.GridFragmentAdapter;
import com.example.ajay.robotic_teaching.Model.AutoImageModel;
import com.example.ajay.robotic_teaching.Model.GridModel;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SighUpActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_signup;
    private TextView txt_sign_in;

    //autoViewPager
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<AutoImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.senses, R.drawable.senses,
            R.drawable.senses,R.drawable.senses
            ,R.drawable.senses,R.drawable.senses};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigh_up);
        inIt();

        //autoViewPager
        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();
        startScroll();
    }
    private void inIt(){

        mPager = (ViewPager) findViewById(R.id.pager);
        btn_signup = (Button)findViewById(R.id.btn_signup);
        txt_sign_in = (TextView) findViewById(R.id.txt_sign_in);
        btn_signup.setOnClickListener(this);
        txt_sign_in.setOnClickListener(this);
    }

    private void openAccount(){

        Intent i = new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.left, R.anim.right);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_signup){
            openAccount();
        }
        if(v == txt_sign_in){
            openAccount();
        }
    }




    /////////////////////////Auto ViewPager/////////////////////////
    private ArrayList<AutoImageModel> populateList() {

        ArrayList<AutoImageModel> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            AutoImageModel imageModel = new AutoImageModel();
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }

    public void startScroll() {

        mPager.setAdapter(new AutoImageAdapter(SighUpActivity.this, imageModelArrayList));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES = imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, 1000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // Message identifier
            private static final int MSG_SOME_MESSAGE = 1000;

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                handler.removeMessages(MSG_SOME_MESSAGE);

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }
}


