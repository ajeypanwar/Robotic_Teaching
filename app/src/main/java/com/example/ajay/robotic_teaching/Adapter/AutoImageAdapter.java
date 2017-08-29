package com.example.ajay.robotic_teaching.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.ajay.robotic_teaching.MainActivity;
import com.example.ajay.robotic_teaching.Model.AutoImageModel;
import com.example.ajay.robotic_teaching.R;

import java.util.ArrayList;

public class AutoImageAdapter extends PagerAdapter {

    private ArrayList<AutoImageModel> imageModelArrayList;
    private LayoutInflater inflater;
    private Context context;


    public AutoImageAdapter(Context context, ArrayList<AutoImageModel> imageModelArrayList) {
        this.context = context;
        this.imageModelArrayList = imageModelArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imageModelArrayList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.autoimages_layout, view, false);
        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);

        imageView.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        view.addView(imageLayout, 0);

        final int cPos = position;
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                //Toast.makeText(context, ""+cPos, Toast.LENGTH_SHORT).show();
                /*if (cPos==0){

                    Intent allPro_i = new Intent(context, MenActivity.class);
                    context.startActivity(allPro_i);
                }
                else if (cPos==1){

                    Intent shop_i = new Intent(context, AllProduct.class);
                    context.startActivity(shop_i);
                }*/
            }
        });
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                      /*  Log.w("touched","down");
                        MainActivity clsStop= new MainActivity();
                        clsStop.stopScroll();*/
                        return true;
                    //break;

                    case MotionEvent.ACTION_UP:
                       /* Log.w("touched","up");
                        MainActivity clsStart= new MainActivity();
                        clsStart.startScroll();*/
                        return true;
                    //break;
                }

                return false;
            }
        });
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}