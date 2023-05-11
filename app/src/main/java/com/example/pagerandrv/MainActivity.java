package com.example.pagerandrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager2 pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        tab = findViewById(R.id.tab);
        pager = findViewById(R.id.pager);
        FragmentManager fm = getSupportFragmentManager();
        Adaptador Adaptador = new Adaptador(fm, getLifecycle());
        pager.setAdapter(Adaptador);
        tab.addTab(tab.newTab().setText("Categorias"));
        tab.addTab(tab.newTab().setText("Pesquisa"));
        tab.addTab(tab.newTab().setText("Relatório"));
        tab.addTab(tab.newTab().setText("Novo"));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tab.selectTab(tab.getTabAt(position));
            }
        });
    }
}