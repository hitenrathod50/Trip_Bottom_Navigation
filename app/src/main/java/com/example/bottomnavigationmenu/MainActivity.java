package com.example.bottomnavigationmenu;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frag;
    BottomNavigationView bV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        frag = findViewById(R.id.frameLayout);

        bV = findViewById(R.id.bottomMenu);

//        setFragmentToScreen(new Frag_1(),0);
        bV.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();


                if(id == R.id.home){
                    setFragmentToScreen(new Frag_1(),true);
                } else if (id==R.id.search_places) {
                    setFragmentToScreen(new Frag_2(),false);
                }
                else if (id==R.id.plan_trip) {
                    setFragmentToScreen(new Frag_3(),false);
                }
                else if (id==R.id.reviews) {
                    setFragmentToScreen(new Frag_4(),false);
                }
                else {
                    setFragmentToScreen(new Frag_5(),false);
                }

                return true;
            }
        });

    }

    private void setFragmentToScreen(Fragment fragment, boolean flag) {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        if(flag){
            ft.add(R.id.frameLayout,fragment);
        } else{
            ft.replace(R.id.frameLayout,fragment);
        }
        ft.commit();
    }
}