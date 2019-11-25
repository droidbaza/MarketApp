package com.droidbaza.market;

import android.os.Bundle;

import com.droidbaza.market.fragments.CategoryFragment;
import com.droidbaza.market.fragments.PersonFragment;
import com.droidbaza.market.fragments.ShoppingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * Created by droidbaza on 25/11/19.
 */


public class MainActivity extends AppCompatActivity {

    private FragmentManager ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView nav = findViewById(R.id.nav_view);
        nav.setOnNavigationItemSelectedListener(listener);

        ft = getSupportFragmentManager();
        CategoryFragment fragment = new CategoryFragment();
        ft.beginTransaction().add(R.id.cont, fragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener
            = item -> {
        switch (item.getItemId()) {
            case R.id.catalog:
                loadFragment(CategoryFragment.newInstance());
                return true;
            case R.id.shopping:
                loadFragment(ShoppingFragment.newInstance());
                return true;
            case R.id.person:
                loadFragment(PersonFragment.newInstance());
                return true;

        }
        return false;
    };

    private void loadFragment(Fragment fragment) {

        ft.beginTransaction().replace(R.id.cont, fragment).commit();
    }

}