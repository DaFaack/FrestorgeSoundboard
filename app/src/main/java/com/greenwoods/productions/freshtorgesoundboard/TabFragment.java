package com.greenwoods.productions.freshtorgesoundboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Andreas;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Clarissa;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Joel;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Karina;
import com.greenwoods.productions.freshtorgesoundboard.tabs.KatjaKrasawixx;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Lexa;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Peggy;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Ronny;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Sandra;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Shyenne;
import com.greenwoods.productions.freshtorgesoundboard.tabs.Torge;

/**
 * Created by Ratan on 7/27/2015.
 */
public class TabFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    int tab_change_counter;
    public InterstitialAd mInterstitialAd;
    AdRequest adRequest;
    public static int int_items = 11 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        interstitital_ad();
        mInterstitialAd.loadAd(adRequest);


            View x =  inflater.inflate(R.layout.tab_layout,null);
            tabLayout = (TabLayout) x.findViewById(R.id.tabs);
            viewPager = (ViewPager) x.findViewById(R.id.viewpager);
            viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            public void onPageSelected(int position) {
                tab_change_counter++;

                if(Integer.parseInt(getText(R.string.interstitial_ad_frequency).toString()) == tab_change_counter){
                    if(mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();

                        AdRequest adRequest = new AdRequest.Builder().build();
                        mInterstitialAd = new InterstitialAd(getContext());
                        mInterstitialAd.setAdUnitId(getText(R.string.interstitial_ad_unit_id) + "");
                        mInterstitialAd.loadAd(adRequest);

                        tab_change_counter = 0;
                    }
                }
            }
        });

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                   }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {

            if(position == 0){
                return new Torge();
            }
            if(position == 1){
                return new Sandra();
            }
            if(position == 2){
                return new Andreas();
            }
            if(position == 3){
                return new Lexa();
            }
            if(position == 4){
                return new Ronny();
            }
            if(position == 5){
                return new Joel();
            }
            if(position == 6){
                return new Peggy();
            }
            if(position == 7){
                return new Karina();
            }
            if(position == 8){
                return new Clarissa();
            }
            if(position == 9){
                return new Shyenne();
            }
            if(position == 10){
                return new KatjaKrasawixx();
            }


        return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Torge";
                case 1 :
                    return "Sandra";
                case 2 :
                    return "Andreas";
                case 3 :
                    return "Lexa";
                case 4 :
                    return "Ronny";
                case 5 :
                    return "Joel";
                case 6 :
                    return "Peggy";
                case 7 :
                    return "Karina";
                case 8 :
                    return "Clarissa";
                case 9 :
                    return "Shyenne";
                case 10 :
                    return "Katja Krasawixx";

            }
                return null;
        }
    }
    // Interstitial Ad
    public void interstitital_ad(){
        adRequest = new AdRequest.Builder().build();
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getText(R.string.interstitial_ad_unit_id) + "");
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                // Ads loaded
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                // Ads closed
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                // Ads couldn't loaded
            }
        });
    }
}
