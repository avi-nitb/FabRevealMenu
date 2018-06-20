package com.avinash.fabrevealmenu;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
{

    private LinearLayout setting_fab_layout, update_fab_layout,shop_fab_layout,main_fab_layout;
    private FloatingActionButton fab_main;
    private Boolean fabExpanded = false;
    private Animation fabOpen, fabClose, rotateClockwise, rotateAnticlockwise;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_fab_layout= (LinearLayout) findViewById(R.id.layoutFabMain);
        setting_fab_layout= (LinearLayout) findViewById(R.id.setting_fab);
        update_fab_layout= (LinearLayout) findViewById(R.id.update_fab);
        shop_fab_layout= (LinearLayout) findViewById(R.id.shop_fab);

        // animations

        fabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.opentoclose);
        fabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.closetoopen);
        rotateAnticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        rotateClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);


        fab_main = (FloatingActionButton) findViewById(R.id.fabMain);
        fab_main.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (fabExpanded){
                    closeFabMenu();
                } else if (!fabExpanded){
                    openFabMenu();
                }
            }
        });

        setting_fab_layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, BottomSheetAnchoringActivity.class);
                startActivity(i);
            }
        });

    }


    private void closeFabMenu(){
        setting_fab_layout.startAnimation(fabClose);
        update_fab_layout.startAnimation(fabClose);
        shop_fab_layout.startAnimation(fabClose);
        shop_fab_layout.setClickable(false);
        setting_fab_layout.setClickable(false);
        update_fab_layout.setClickable(false);
        fab_main.startAnimation(rotateAnticlockwise);
        fabExpanded=false;
    }
    private void openFabMenu(){
        setting_fab_layout.startAnimation(fabOpen);
        update_fab_layout.startAnimation(fabOpen);
        shop_fab_layout.startAnimation(fabOpen);
        shop_fab_layout.setClickable(true);
        setting_fab_layout.setClickable(true);
        update_fab_layout.setClickable(true);
        fab_main.startAnimation(rotateClockwise);
        fabExpanded= true;
    }


}
