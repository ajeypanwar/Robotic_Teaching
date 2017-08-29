package com.example.ajay.robotic_teaching;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ajay.robotic_teaching.Adapter.ListAdapter;
import com.example.ajay.robotic_teaching.Model.GridModel;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView grid_recycler_view;
    private ListAdapter grid_Adapter;
    private List<GridModel> grid_data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);

        grid_recycler_view = (RecyclerView)view.findViewById(R.id.list_recycler_view);
        grid_data = new ArrayList<>();
        grid_Adapter = new ListAdapter(getActivity(), grid_data);
        // RecyclerView.LayoutManager horizontal_LayoutManager = new GridLayoutManager(this, 4);
        LinearLayoutManager horizontal_LayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        grid_recycler_view.setLayoutManager(horizontal_LayoutManager);
        grid_recycler_view.setAdapter(grid_Adapter);

        prepareAlbums();

        return view;
    }


    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,
                R.drawable.ic_action_group,};

        GridModel a = new GridModel("Quotes", "Robotic teaching is the well-known process", covers[0]);
        grid_data.add(a);

        a = new GridModel("Gratitute", "Robotic teaching is the well-known process", covers[1]);
        grid_data.add(a);

        a = new GridModel("DIGGING", "Robotic teaching is the well-known process", covers[2]);
        grid_data.add(a);

        a = new GridModel("MINDFULLNESS", "Robotic teaching is the well-known process", covers[3]);
        grid_data.add(a);

        a = new GridModel("APPROACH", "Robotic teaching is the well-known process", covers[1]);
        grid_data.add(a);

        a = new GridModel("DEEPER", "Robotic teaching is the well-known process", covers[2]);
        grid_data.add(a);

        a = new GridModel("MINDFULLNESS", "Robotic teaching is the well-known process", covers[3]);
        grid_data.add(a);

        a = new GridModel("APPROACH", "Robotic teaching is the well-known process", covers[1]);
        grid_data.add(a);

        a = new GridModel("DIGGING", "Robotic teaching is the well-known process", covers[2]);
        grid_data.add(a);

        a = new GridModel("MINDFULLNESS", "Robotic teaching is the well-known process", covers[3]);
        grid_data.add(a);

        grid_Adapter.notifyDataSetChanged();
    }


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
