package com.demo.comicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;

import com.demo.comicapp.databinding.ActivityMainBinding;
import com.demo.comicapp.databinding.ActivityRegisterBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Fragment activeFragment;
    private HomeFragment homeFragment = new HomeFragment();
    private LikeFragment likeFragment = new LikeFragment();
    private OfflineFragment offlineFragment = new OfflineFragment();
    private SettingsFragment settingsFragment = new SettingsFragment();
    FragmentManager fm = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        initFragment();
        initBottomNav();

    }
    public void initBottomNav() {
        binding.bottomNavigation.setItemIconTintList(null);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_nav_home:
                        addFragment(homeFragment);
                        break;
                    case R.id.bot_nav_like:
                        addFragment(likeFragment);
                        break;
                    case R.id.bot_nav_offline:
                        addFragment(offlineFragment);
                        break;
                    case R.id.bot_nav_settings:
                        addFragment(settingsFragment);
                        break;
                }
                return true;
            }
        });
    }

    public void addFragment(Fragment frag) {
        fm.beginTransaction().hide(activeFragment).show(frag).commit();
        activeFragment = frag;
    }

    private void initFragment() {
        fm.beginTransaction().add(R.id.frame_container, settingsFragment, "4").hide(settingsFragment).commit();
        fm.beginTransaction().add(R.id.frame_container, offlineFragment, "3").hide(offlineFragment).commit();
        fm.beginTransaction().add(R.id.frame_container, likeFragment, "2").hide(likeFragment).commit();
        fm.beginTransaction().add(R.id.frame_container, homeFragment, "1").commit();
        activeFragment = homeFragment;
    }
}