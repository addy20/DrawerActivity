package com.aditya.draweractivity1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.time.temporal.TemporalAccessor;


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
        View headerView=navView.getHeaderView(0);
        TextView tvUser=headerView.findViewById(R.id.tv_header);
        tvUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Header is Clciked", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
       switch (item.getItemId()){
           case R.id.action_edit:
               startActivity(new Intent(MainActivity.this,BottomNavigationActivity.class));
               break;
           case R.id.action_delete:
               Toast.makeText(this, "Delete is Clicked", Toast.LENGTH_SHORT).show();
               break;
           case R.id.action_move:
               Toast.makeText(this, "Move is Clicked", Toast.LENGTH_SHORT).show();
               break;
           default:
               Toast.makeText(this, "Setting is clicked", Toast.LENGTH_SHORT).show();
               break;

       }
        return true;
    }
}