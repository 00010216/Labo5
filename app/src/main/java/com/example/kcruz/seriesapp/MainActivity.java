package com.example.kcruz.seriesapp;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FavoritesFragment.OnFragmentInteractionListener, SeriesFragment.OnFragmentInteractionListener {
    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;
    LinearLayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        series = new ArrayList<>();
        rv = findViewById(R.id.recycler);
        rv.setHasFixedSize(true);
        lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(lManager);

        prepareSeries();

        adapter = new SeriesAdapter(series);
        rv.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout); //guardando la vista del tablayout en un objeto
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Series)); //asignandole el nombre respectivo al tab
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Favorites));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter pageAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //dandole las funcionalidades a las tabs
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void prepareSeries(){
        String TAG = "Mensaje";
        series = new ArrayList<>();
        series.add(new Serie("Flash","13", R.drawable.flash, "TV show created by Robert"));
        series.add(new Serie("The Walking Dead","13", R.drawable.twd, "TV show created by Robert"));
        series.add(new Serie("Breaking bad","13", R.drawable.bbad, "TV show created by Vince Gilligan"));
    }

}
