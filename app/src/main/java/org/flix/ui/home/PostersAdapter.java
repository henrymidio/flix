package org.flix.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.flix.R;
import org.flix.model.Movie;
import org.flix.ui.InfoMovieFragment;

import java.util.List;

public class PostersAdapter extends RecyclerView.Adapter<PostersAdapter.MyViewHolder> {

    private List<Movie> movies;
    private static Context context;
    private static FragmentManager fm;

    // Provide a suitable constructor (depends on the kind of dataset)
    public PostersAdapter(List<Movie> movies, final Context context, final FragmentManager fm) {
        this.movies = movies;
        this.context = context;
        this.fm = fm;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PostersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poster_item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.bind(movies.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movies.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private ImageView moviePhoto;

        public MyViewHolder(View v) {
            super(v);

            moviePhoto = v.findViewById(R.id.testView);

        }

        public void bind(final Movie movie) {

            Glide.with(context)
                    .load(movie.getPoster())
                    .into(moviePhoto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("movieId", movie.getId());

                    InfoMovieFragment infoMovieFragment = new InfoMovieFragment();
                    infoMovieFragment.setArguments(bundle);
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_container, infoMovieFragment);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            });
        }
    }
}