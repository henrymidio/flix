package org.flix.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.flix.R;
import org.flix.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.libreflix_logo);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, new HomeFragment());
        ft.commit();
    }
}
