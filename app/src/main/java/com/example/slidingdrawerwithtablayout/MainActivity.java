package com.example.slidingdrawerwithtablayout;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;

import com.example.adapter.DrawerAdapter;
import com.example.slider.FriendsFragment;
import com.example.slider.HomeFragment;
import com.example.slider.MessagesFragment;
import com.example.tab.DummyTabContent;
import com.example.tab.Tab1Fragment;
import com.example.tab.Tab2Fragment;
import com.example.tab.Tab3Fragment;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity implements OnClickListener {

    // First We Declare Titles And Icons For Our Navigation Drawer List View
    // This Icons And Titles Are holded in an Array as you can see

    String TITLES[] = {"Home", "Friends", "Message"};
    int ICONS[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};

    // Similarly we Create a String Resource for the name and email in the
    // header view
    // And we also create a int resource for profile picture in the header view

    String NAME = "ABC";
    String EMAIL = "abc@gmail.com";
    int PROFILE = R.drawable.aka;

    private Toolbar toolbar; // Declaring the Toolbar Object

    RecyclerView mRecyclerView; // Declaring RecyclerView
    RecyclerView.Adapter mAdapter; // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager; // Declaring Layout Manager as a
    // linear layout manager
    DrawerLayout Drawer; // Declaring DrawerLayout
    ActionBarDrawerToggle mDrawerToggle; // Declaring Action Bar Drawer Toggle

    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		/*
         * Assinging the toolbar object ot the view and setting the the Action
		 * bar to our toolbar
		 */
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

        mRecyclerView.setHasFixedSize(true);

        mAdapter = new DrawerAdapter(MainActivity.this, TITLES, ICONS, NAME,
                EMAIL, PROFILE);
        mRecyclerView.setAdapter(mAdapter);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar,
                R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont
                // want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }

        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the
        // Drawer toggle
        mDrawerToggle.syncState(); // Finally we set the drawer toggle sync
        // State

        FragmentTransaction tx = getFragmentManager().beginTransaction();
        HomeFragment feedbackFragment = HomeFragment.newInstance();
        tx.replace(R.id.main, feedbackFragment).commit();

        /*call setTab() function*/
        setTab();

    }

    private void setTab() {
        TabHost tHost = (TabHost) findViewById(android.R.id.tabhost);
        tHost.setup();

        /**
         * Defining Tab Change Listener event. This is invoked when tab is
         * changed
         */
        TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                FragmentTransaction tx = getFragmentManager()
                        .beginTransaction();
                Tab1Fragment tab1Fragment = null;
                Tab2Fragment tab2Fragment = null;
                Tab3Fragment tab3Fragment = null;

                /** If current tab is android */
                if (tabId.equalsIgnoreCase("FIRST TAB")) {
                    tx = getFragmentManager().beginTransaction();
                    tab1Fragment = Tab1Fragment.newInstance();
                    tx.replace(R.id.main, tab1Fragment).commit();
                } else if (tabId.equalsIgnoreCase("SECOND TAB")) {
                    tx = getFragmentManager().beginTransaction();
                    tab2Fragment = Tab2Fragment.newInstance();
                    tx.replace(R.id.main, tab2Fragment).commit();
                } else if (tabId.equalsIgnoreCase("THIRD TAB")) {
                    tx = getFragmentManager().beginTransaction();
                    tab3Fragment = Tab3Fragment.newInstance();
                    tx.replace(R.id.main, tab3Fragment).commit();
                }

            }
        };

        /** Setting tabchangelistener for the tab */
        tHost.setOnTabChangedListener(tabChangeListener);

        /** Defining tab builder for Andriod tab */
        TabHost.TabSpec tSpecFirst = tHost.newTabSpec("FIRST TAB");
        tSpecFirst.setIndicator("FIRST TAB",
                getResources().getDrawable(R.drawable.aka));
        tSpecFirst.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecFirst);

        /** Defining tab builder for Apple tab */
        TabHost.TabSpec tSpeSecond = tHost.newTabSpec("SECOND TAB");
        tSpeSecond.setIndicator("SECOND TAB",
                getResources().getDrawable(R.drawable.aka));
        tSpeSecond.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpeSecond);

        /** Defining tab builder for Apple tab */
        TabHost.TabSpec tSpecThird = tHost.newTabSpec("THIRD TAB");
        tSpecThird.setIndicator("THIRD TAB",
                getResources().getDrawable(R.drawable.aka));
        tSpecThird.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecThird);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relRow:
                int pos = (Integer) v.getTag();

                if (pos == 1) {
                    ft = getFragmentManager().beginTransaction();
                    HomeFragment f1Fragment = HomeFragment.newInstance();
                    ft.replace(R.id.main, f1Fragment).commit();
                } else if (pos == 2) {
                    ft = getFragmentManager().beginTransaction();
                    FriendsFragment f3Fragment = FriendsFragment.newInstance();
                    ft.replace(R.id.main, f3Fragment).commit();
                } else if (pos == 3) {
                    ft = getFragmentManager().beginTransaction();
                    MessagesFragment f2Fragment = MessagesFragment.newInstance();
                    ft.replace(R.id.main, f2Fragment).commit();
                }

                Drawer.closeDrawer(mRecyclerView);
                break;

            default:
                break;
        }

    }

}
