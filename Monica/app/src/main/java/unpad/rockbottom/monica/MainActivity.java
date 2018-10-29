package unpad.rockbottom.monica;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout sDrawerLayout;
    private ActionBarDrawerToggle sToogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        sToogle = new ActionBarDrawerToggle(this,sDrawerLayout,R.string.open,R.string.close);
        sDrawerLayout.addDrawerListener(sToogle);
        sToogle.syncState();

        BottomNavigationView bottomNav = findViewById(R.id.bottomnav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if(sToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.home_menu:
                selectedFragment = new FragmentHome();
                break;
            case R.id.profile_menu:
                selectedFragment = new FragmentProfile();
                break;
            case R.id.settings_menu:
                selectedFragment = new FragmentSettings();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        return true;
            }
    };
}
