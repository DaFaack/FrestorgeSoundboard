package com.penta.games.freshtorgesoundboardpro;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
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

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public MediaPlayer mp;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    public static boolean isTesting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Banner Ad
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        isTesting=false;

        final File FILES_PATH = new File(Environment.getExternalStorageDirectory(), "Android/data/com.penta.games.freshtorgesoundboard/files");


        if (Environment.MEDIA_MOUNTED.equals(

                Environment.getExternalStorageState())) {

            if (!FILES_PATH.mkdirs()) {

                Log.w("error", "Could not create " + FILES_PATH);

            }

        } else {

            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();

            finish();

        }


        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                1);
        /**
         *Setup the DrawerLayout and NavigationView
         */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         *
         *
         *
         */
        mNavigationView.setItemIconTintList(null);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();






                if(menuItem.getItemId() == R.id.teilen){
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "✶Freshtorge Soundboard - Pro Version✶");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "✶Hol dir das Freshtorge PREMIUM Soundboard mit Freshtorges besten Sounds✶\n\nhttps://play.google.com/store/apps/details?id=com.penta.games.freshtorgesoundboardpro&hl=de");
                    startActivity(Intent.createChooser(shareIntent,  "Teilen über..."));
                }


                if (menuItem.getItemId() == R.id.nav_item_inbox) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.instagram) {
                    String url = "https://instagram.com/_u/coding.empire/?r=sun1";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.flappyjulien) {
                    String url = "https://play.google.com/store/apps/details?id=com.pentagames.flappyjulien.android&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.flappybibi) {
                    String url = "https://play.google.com/store/apps/details?id=com.pentagames.flappybibi.android&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.bibisepilierer) {
                    String url = "https://play.google.com/store/apps/details?id=com.jakob2000.bibisepilierer&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.miimii) {
                    String url = "https://play.google.com/store/apps/details?id=com.aaron.waller.miimiisoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.simondesue) {
                    String url = "https://play.google.com/store/apps/details?id=com.aaron.waller.simondesuesoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.elotrix) {
                    String url = "https://play.google.com/store/apps/details?id=com.penta.games.elotrixsoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.gronkh) {
                    String url = "https://play.google.com/store/apps/details?id=com.aaron.waller.gronkhsoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.tanzverbot) {
                    String url = "https://play.google.com/store/apps/details?id=com.aaron.waller.tanzverbotsoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.merkel) {
                    String url = "https://play.google.com/store/apps/details?id=com.aaron.waller.angelasoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.freshtorge) {
                    String url = "https://play.google.com/store/apps/details?id=com.penta.games.freshtorgesoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.dummefage) {
                    String url = "https://play.google.com/store/apps/details?id=com.penta.games.dummefragenet&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);


                }

                if (menuItem.getItemId() == R.id.bauerhermann) {
                    String url = "https://play.google.com/store/apps/details?id=com.aaron.waller.bauerhermannsoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.bullshittv) {
                    String url = "https://play.google.com/store/apps/details?id=com.penta.games.bullshittvsoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.crispyrob) {
                    String url = "https://play.google.com/store/apps/details?id=com.aaron.waller.crispyrobsoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.iblali) {
                    String url = "https://play.google.com/store/apps/details?id=com.aaron.waller.iblalisoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.julien) {
                    String url = "https://play.google.com/store/apps/details?id=com.penta.games.julienbamsoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }



                if (menuItem.getItemId() == R.id.kuchentv) {
                    String url = "https://play.google.com/store/apps/details?id=com.aaron.waller.kuchentvsoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.inscope) {
                    String url = "https://play.google.com/store/apps/details?id=com.penta.games.inscopesoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.avive) {
                    String url = "https://play.google.com/store/apps/details?id=com.penta.games.inscopesoundboard&hl=de";

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    onPause();
                    startActivity(intent);
                }


                if (menuItem.getItemId() == R.id.email) {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","pentagames.business@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_TEXT,"\n\n\n\n\n\n\n\n[Packagename:com.penta.games.freshtorgesoundboardpro  ---Diese Info nicht löschen---]");
                    startActivity(Intent.createChooser(emailIntent, "E-Mail senden..."));
                }


                if (menuItem.getItemId() == R.id.rechtliches) {
                    AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                    a_builder.setMessage(R.string.rechtliches)
                            .setCancelable(true)
                            .setNegativeButton("Verstanden", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = a_builder.create();
                    alert.setTitle("Rechtliches");
                    alert.show();
                }




                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();


    }




    public void torgeItemClicked(int position) {

        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Torge.soundfiles[position]);
        mp.start();
    }

    public void sandraItemClicked(int position) {
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Sandra.soundfiles[position]);
        mp.start();

    }
    public void andreasItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Andreas.soundfiles[position]);
        mp.start();

    }
    public void lexxaItemClicked(int position) {

        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Lexa.soundfiles[position]);
        mp.start();

    }
    public void ronnyItemClicked(int position) {

        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Ronny.soundfiles[position]);
        mp.start();

    }

    public void joelItemClicked(int position) {

        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Joel.soundfiles[position]);
        mp.start();

    }
    public void peggyItemClicked(int position) {

        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Peggy.soundfiles[position]);
        mp.start();

    }
    public void karinaItemClicked(int position) {

        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Karina.soundfiles[position]);
        mp.start();

    }
    public void clarissaItemClicked(int position) {

        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Clarissa.soundfiles[position]);
        mp.start();

    }
    public void katjaItemClicked(int position) {

        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, KatjaKrasawixx.soundfiles[position]);
        mp.start();

    }
    public void shyenneItemClicked(int position) {

        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Shyenne.soundfiles[position]);
        mp.start();

    }



    public void cleanUpMediaPlayer() {
        if (mp != null) {
            try {
                mp.stop();
                mp.release();
                mp = null;
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Ein Fehler ist aufgetreten, versuche die App neu zu starten.", Toast.LENGTH_LONG).show();

            }
        }
    }



}
