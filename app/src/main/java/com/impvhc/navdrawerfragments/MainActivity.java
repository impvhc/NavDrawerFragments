package com.impvhc.navdrawerfragments;

import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.impvhc.navdrawerfragments.fragments.Fragment1;
import com.impvhc.navdrawerfragments.fragments.Fragment2;
import com.impvhc.navdrawerfragments.fragments.Fragment3;
import com.impvhc.navdrawerfragments.methods.NavDrawerItem;
import com.impvhc.navdrawerfragments.methods.NavDrawerListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] titles={"Option 1","Option 2","Option 3"};


    private DrawerLayout containerLayout;
    private LinearLayout menuLayout;
    private ListView menuItems;
    private ImageView menuImage;

    private ActionBarDrawerToggle menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerLayout=(DrawerLayout)findViewById(R.id.container_main);
        menuLayout=(LinearLayout) findViewById(R.id.menu_layout);
        menuItems=(ListView) findViewById(R.id.item_menu);
        menuImage=(ImageView) findViewById(R.id.img_menu);
        menuButton=
                new ActionBarDrawerToggle(this,containerLayout,R.drawable.ic_action_view_headline,R.string.open,R.string.close)
                {
                    /** Called when a drawer has settled in a completely open state. */
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                        invalidateOptionsMenu();
                    }
                    /** Called when a drawer has settled in a completely closed state. */
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                        invalidateOptionsMenu();
                    }
                };

        // Set the drawer toggle as the DrawerListener
        containerLayout.setDrawerListener(menuButton);
        //Enable button in the menu bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        createListMenu();

    }

    public void createListMenu(){
        ArrayList<NavDrawerItem> navDrawerItems=new ArrayList<NavDrawerItem>();
        NavDrawerListAdapter adapter;
        menuImage.setImageResource(R.mipmap.ic_launcher);
        for (int i=0;i<titles.length;i++){
            navDrawerItems.add(new NavDrawerItem(titles[i],R.mipmap.ic_launcher));
        }
        adapter=new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);
        menuItems.setAdapter(adapter);
        menuItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onSelectItemMenu(position);
            }
        });
    }

    public void onSelectItemMenu(int position){
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
            default:
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container_frames, fragment)
                .commit();
        menuItems.setItemChecked(position, true);
        getSupportActionBar().setTitle(titles[position]);
        containerLayout.closeDrawer(menuLayout);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        menuButton.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        menuButton.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (menuButton.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }
}
