package com.example.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer_lay;
    NavigationView nav_view;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer_lay = findViewById(R.id.drawer_lay);
        nav_view = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer_lay,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);

        drawer_lay.addDrawerListener(toggle);
        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.starred){
                    Toast.makeText(MainActivity.this, "Here your questions will be saved", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.suggestions){
                    Toast.makeText(MainActivity.this, "Suggestions will be displayed", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.help_center){
                    Toast.makeText(MainActivity.this, "Will try to help", Toast.LENGTH_SHORT).show();
                }else{//mail_us
                    Toast.makeText(MainActivity.this, "Mail us buddy !", Toast.LENGTH_SHORT).show();
                }

                drawer_lay.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer_lay.isDrawerOpen(GravityCompat.START)) {
            drawer_lay.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }
}