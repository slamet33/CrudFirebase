package com.iu33.crudfirebase.admob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.iu33.crudfirebase.R;
import com.iu33.crudfirebase.helper.MyFunction;

public class AdmobActivity extends MyFunction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admob);
    }

    public void onbanner(View view) {
        myIntent(BannerActivity.class);
    }

    public void onreward(View view) {
        myIntent(RewardVideoActivity.class);
    }

    public void oninterstitial(View view) {
        myIntent(IntersitialActivity.class);
    }
}
