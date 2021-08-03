package com.aditya.draweractivity1;

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

import org.jetbrains.annotations.NotNull;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar=findViewById(R.id.tl_drawer);
        setSupportActionBar(mToolbar);
        drawerLayout = findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle drawerToogle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, mToolbar, R.string.open, R.string.close);
        drawerToogle.syncState();

        NavigationView navView = findViewById(R.id.sliding_navigation);
        navView.setNavigationItemSelectedListener(this);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.action_move) {
            Toast.makeText(MainActivity.this, "Move Clicked", Toast.LENGTH_LONG).show();
        }
        return false;
    }
}