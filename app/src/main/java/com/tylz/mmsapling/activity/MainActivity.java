package com.tylz.mmsapling.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.fragment.ExampleFra;
import com.tylz.mmsapling.fragment.WidgetFra;

import java.lang.reflect.Method;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity
        extends AppCompatActivity
{
    private DrawerLayout          mDrawerLayout;
    private Toolbar               mToolbar;
    private NavigationView        mNavigationView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initNavigationContent();

    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.main_navigition_view);
        setSupportActionBar(mToolbar);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,
                                                           mDrawerLayout,
                                                           mToolbar,
                                                           R.string.drawer_open,
                                                           R.string.drawer_close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
    }

    private void initNavigationContent() {
        View            headView = mNavigationView.inflateHeaderView(R.layout.navigation_headview);
        CircleImageView civHead  = (CircleImageView) headView.findViewById(R.id.civ_head);
        if (civHead != null) {
            civHead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.closeDrawers();
                }
            });
        }
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item_example:
                        switchToFragment(new ExampleFra(), R.string.navigation_example);
                        break;
                    case R.id.navigation_item_widget:
                        switchToFragment(new WidgetFra(),R.string.navigation_widget);
                        break;
                    default:
                        break;
                }
                item.setCheckable(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

    }

    private void switchToFragment(Fragment fragment, int strId) {
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.main_content, fragment)
                                   .commit();
        mToolbar.setTitle(strId);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_search:
                Toast.makeText(this, R.string.app_name, Toast.LENGTH_SHORT)
                     .show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if(menu!= null){
            if(menu.getClass() == MenuBuilder.class){
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }
}
