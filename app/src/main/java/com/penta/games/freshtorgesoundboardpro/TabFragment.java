package com.penta.games.freshtorgesoundboardpro;

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

import com.penta.games.freshtorgesoundboardpro.tabs.Andreas;
import com.penta.games.freshtorgesoundboardpro.tabs.Clarissa;
import com.penta.games.freshtorgesoundboardpro.tabs.Joel;
import com.penta.games.freshtorgesoundboardpro.tabs.Karina;
import com.penta.games.freshtorgesoundboardpro.tabs.KatjaKrasawixx;
import com.penta.games.freshtorgesoundboardpro.tabs.Lexa;
import com.penta.games.freshtorgesoundboardpro.tabs.Peggy;
import com.penta.games.freshtorgesoundboardpro.tabs.Ronny;
import com.penta.games.freshtorgesoundboardpro.tabs.Sandra;
import com.penta.games.freshtorgesoundboardpro.tabs.Shyenne;
import com.penta.games.freshtorgesoundboardpro.tabs.Torge;

/**
 * Created by Ratan on 7/27/2015.
 */
public class TabFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 11 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        /**
         *Inflate tab_layout and setup Views.
         */
            View x =  inflater.inflate(R.layout.tab_layout,null);
            tabLayout = (TabLayout) x.findViewById(R.id.tabs);
            viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));




        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

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

}
