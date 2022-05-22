package com.example.androidclockapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager2);

        viewPager.setAdapter(new FragmentStateAdapter(MainActivity.this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Fragment fragment = null;

                switch (position){
                    case 0:
                        fragment = new AlarmFragment();
                        break;
                    case 1:
                        fragment = new WorldtimeFragment();
                        break;
                    case 2:
                        fragment = new StopwatchFragment();
                        break;
                    default:
                        fragment = new TimerFragment();
                }

                return fragment;
            }

            @Override
            public int getItemCount() {
                return 4;
            }
        });

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:
                                tab.setText("알람");
                                break;
                            case 1:
                                tab.setText("세계시각");
                                break;
                            case 2:
                                tab.setText("스톱워치");
                                break;
                            case 3:
                                tab.setText("타이머");
                                break;
                        }
                    }
                }).attach();
    }
}