package com.bnxf.bnxf;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bnxf.bnxf.util.BottomNavigationViewHelper;

public class IndexActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        mBottomNavigationBar = findViewById(R.id.activity_index_bar);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationBar);

    }

}
