package org.flix.ui.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.flix.R;
import org.flix.model.Movie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class HomeFragment extends Fragment {

    private List<Movie> movies = new LinkedList<>();


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.my_recycler_view);
        RecyclerView mRecyclerView2 = view.findViewById(R.id.my_recycler_view2);
        RecyclerView mRecyclerView3 = view.findViewById(R.id.my_recycler_view3);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView2.setHasFixedSize(true);
        mRecyclerView3.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView2.setLayoutManager(layoutManager2);
        mRecyclerView3.setLayoutManager(layoutManager3);

        movies.add(new Movie(null, "https://http2.mlstatic.com/poster-cartaz-filme-x-man-apocalipse-D_NQ_NP_736032-MLB25882760882_082017-F.jpg"));
        movies.add(new Movie(null, "http://www.itaucinemas.com.br/_img/_fotos_galerias/1314.jpg"));
        movies.add(new Movie(null, "https://www.hardmusica.pt/media/k2/items/cache/16711f6dbc3d07b3bb301107011ec676_XL.jpg"));
        movies.add(new Movie(null, "http://static1.purebreak.com.br/articles/6/51/86/@/28652-cartaz-de-guardioes-da-galaxia-620x0-3.jpg"));
        movies.add(new Movie(null, "http://br.web.img3.acsta.net/newsv7/14/09/18/23/08/049568.jpg"));

        // specify an adapter (see also next example)
        PostersAdapter mAdapter = new PostersAdapter(movies, getContext(), getFragmentManager());

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView2.setAdapter(mAdapter);
        mRecyclerView3.setAdapter(mAdapter);

        return view;
    }

}
