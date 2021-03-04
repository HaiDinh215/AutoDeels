package com.project.AutoDeelsoftwareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int TIME_OUT = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, signup_login.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);

        //BottomNavigationView bottomnav = findViewById(R.id.mobile_navigation);
        //bottomnav.setOnNavigationItemSelectedListener(navListener);
    }

//    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment selectedFragment = null;
//
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    selectedFragment = new HomeFragment();
//                    break;
//                case R.id.navigation_dashboard:
//                    selectedFragment = new DashboardFragment();
//                    break;
//                case R.id.navigation_notifications:
//                    selectedFragment = new NotificationsFragment();
//                    break;
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
//
//            return true;
//        }
//    };
}