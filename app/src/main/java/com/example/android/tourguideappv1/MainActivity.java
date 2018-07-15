package com.example.android.tourguideappv1;

import android.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private String mTitle = "Tour of St. Louis";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped


                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        android.support.v4.app.Fragment fragment = null;
                        Class fragmentClass;
                        int menuItemLayoutResource = menuItem.getItemId();
                        switch(menuItemLayoutResource) {
                            case R.id.shopping:
                                fragmentClass = ShoppingFragment.class;
                                mTitle = "Shopping";
                                break;
                            case R.id.food:
                                fragmentClass = FoodFragment.class;
                                mTitle = "Local Dining";
                                break;
                            case R.id.buildings:
                                fragmentClass = MonumentFragment.class;
                                mTitle = "Monuments and Buildings";
                                break;
                            default:
                                fragmentClass = FavoritesFragment.class;
                                mTitle = "Local Favorites";
                        }

                        try {
                            fragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        // Insert the fragment by replacing any existing fragment
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null);
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
                        toolbar.setTitle(mTitle);

                        RelativeLayout titleScreen = (RelativeLayout) findViewById(R.id.title_layout_main);
                        titleScreen.removeAllViewsInLayout();
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
