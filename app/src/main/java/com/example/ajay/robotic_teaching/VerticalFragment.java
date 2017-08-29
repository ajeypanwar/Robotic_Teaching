package com.example.ajay.robotic_teaching;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ajay.robotic_teaching.Adapter.GridAdapter;
import com.example.ajay.robotic_teaching.Model.GridModel;

import java.util.ArrayList;
import java.util.List;

public class VerticalFragment extends Fragment {

    private RecyclerView grid_recycler_view;
    private GridAdapter grid_Adapter;
    private List<GridModel> grid_data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.vertical_fragment, container, false);

       /* grid_recycler_view = (RecyclerView)view.findViewById(R.id.grid_recycler_view);
        grid_data = new ArrayList<>();
        grid_Adapter = new GridAdapter(getActivity(), grid_data);
        RecyclerView.LayoutManager grid_LayoutManager = new GridLayoutManager(getActivity(), 2);
        grid_recycler_view.setLayoutManager(grid_LayoutManager);
        grid_recycler_view.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        grid_recycler_view.setItemAnimator(new DefaultItemAnimator());
        grid_recycler_view.setAdapter(grid_Adapter);*/

        grid_recycler_view = (RecyclerView)view.findViewById(R.id.vertical_recycler_view);
        grid_data =  new ArrayList<>();
        grid_Adapter = new GridAdapter(getActivity(), grid_data);
        // RecyclerView.LayoutManager horizontal_LayoutManager = new GridLayoutManager(this, 4);
        LinearLayoutManager horizontal_LayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        grid_recycler_view.setLayoutManager(horizontal_LayoutManager);
        grid_recycler_view.setAdapter(grid_Adapter);

        prepareAlbums();

        return view;
    }



    private void prepareAlbums() {
        int[] covers = new int[]{
                R.mipmap.education2,
                R.mipmap.education3,
                R.mipmap.education4,
                R.mipmap.education6,
                R.mipmap.education7,
                R.mipmap.education8,
                R.mipmap.education9,
                R.mipmap.education2,
                R.mipmap.education3,
                R.mipmap.education4,
                R.mipmap.education6,
                R.mipmap.education7,
                R.mipmap.education8,
                R.mipmap.education9,};

        GridModel a = new GridModel("THE FIRST WEEK","Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[0]);
        grid_data.add(a);

        a = new GridModel("A NEW APPROACH", "Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[1]);
        grid_data.add(a);

        a = new GridModel("DIGGING DEEPER", "Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[2]);
        grid_data.add(a);

        a = new GridModel("MINDFULLNESS", "Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[3]);
        grid_data.add(a);

        a = new GridModel("A NEW APPROACH", "Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[1]);
        grid_data.add(a);

        a = new GridModel("DIGGING DEEPER", "Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[2]);
        grid_data.add(a);

        a = new GridModel("MINDFULLNESS", "Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[3]);
        grid_data.add(a);

        a = new GridModel("A NEW APPROACH", "Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[1]);
        grid_data.add(a);

        a = new GridModel("DIGGING DEEPER", "Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[2]);
        grid_data.add(a);

        a = new GridModel("MINDFULLNESS", "Robotic teaching is the well-known process to make a desired trajectory by using a teaching pendant", covers[3]);
        grid_data.add(a);

        grid_Adapter.notifyDataSetChanged();
    }
    /**
     * RecyclerView item decoration - give equal margin around  item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}

