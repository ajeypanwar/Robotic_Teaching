package com.example.ajay.robotic_teaching;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private ImageView img_write,img_degree,img_reading,img_complete,img_center;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);

        img_write = (ImageView) view.findViewById(R.id.img_write);
        img_degree = (ImageView) view.findViewById(R.id.img_degree);
        img_reading = (ImageView) view.findViewById(R.id.img_reading);
        img_complete = (ImageView) view.findViewById(R.id.img_complete);
        img_center = (ImageView) view.findViewById(R.id.img_center);
        img_write.setOnClickListener(this);
        img_degree.setOnClickListener(this);
        img_reading.setOnClickListener(this);
        img_complete.setOnClickListener(this);
        img_center.setOnClickListener(this);


        img_center.setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);

       /* final ImageView v = (ImageView)view.findViewById(R.id.img_center);
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                switch (arg1.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.setImageBitmap(res.getDrawable(R.drawable.img_down));
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL:{
                        v.setImageBitmap(res.getDrawable(R.drawable.img_up));
                        break;
                    }
                }
                return true;
            }
        });*/

        return view;
    }


    private void homeToBooks(){

        Intent i = new Intent(getActivity(), BooksActivity.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.left, R.anim.right);
    }

    @Override
    public void onClick(View view) {

        if(view == img_write){
            homeToBooks();
        }
        if(view == img_degree){
            homeToBooks();
        }
        if(view == img_reading){
            homeToBooks();
        }
        if(view == img_complete){
            homeToBooks();
        }
        if(view == img_center){
            homeToBooks();
        }
    }
}
