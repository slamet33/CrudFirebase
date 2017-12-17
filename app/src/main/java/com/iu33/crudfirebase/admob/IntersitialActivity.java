package com.iu33.crudfirebase.admob;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.iu33.crudfirebase.R;
import com.iu33.crudfirebase.helper.MyFunction;

public class IntersitialActivity extends MyFunction{
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intersitial);
        mInterstitialAd = new InterstitialAd(this);

        mInterstitialAd.setAdUnitId("ca-app-pub-8603499623556542/4445284389");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                Log.i("Ads", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad");
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i("Ads", "onAdClosed");
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    public void oninterstitial(View view) {
        myToast("tunggu berapa saat");
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            myToast("The interstitial wasn't loaded yet");
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
}
