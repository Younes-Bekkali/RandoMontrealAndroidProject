package qc.bdeb.randomontreal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import qc.bdeb.randomontreal.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigation.toolbar);
        binding.appBarNavigation.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;


        //Menu to Mybucketlist
        MenuItem menuItem1 = navigationView.getMenu().findItem(R.id.viewgbucketlist);
        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentMenuToGallery = new Intent(NavigationActivity.this, MyBucketListActivity.class);
                startActivity(intentMenuToGallery);
                return true;
            }
        });

        //Menu to parks (gallery)
        MenuItem menuItem2 = navigationView.getMenu().findItem(R.id.parksgallery);
        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentMenuToGallery = new Intent(NavigationActivity.this, GalleryActivity.class);
                startActivity(intentMenuToGallery);
                return true;
            }
        });

        //Menu to Locations
        MenuItem menuItem3 = navigationView.getMenu().findItem(R.id.locations);
        menuItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentMenuToLocations = new Intent(NavigationActivity.this, LocationActivity.class);
                startActivity(intentMenuToLocations);
                return true;
            }
        });

        //Menu to Contact us
        MenuItem menuItem4 = navigationView.getMenu().findItem(R.id.contactus);
        menuItem4.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentMenuToContact = new Intent(NavigationActivity.this, ContactusActivity.class);
                startActivity(intentMenuToContact);
                return true;
            }
        });


        //
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onViewMyBucketList(View view){
        Intent intentToGallery = new Intent(NavigationActivity.this, MyBucketListActivity.class);
        startActivity(intentToGallery);
    }

    public void onParks(View  view){
        Intent intentToParks = new Intent(NavigationActivity.this, GalleryActivity.class);
        startActivity(intentToParks);
    }

    public void onContact(View view){
        Intent intentToContact = new Intent(NavigationActivity.this, ContactusActivity.class);
        startActivity(intentToContact);
    }

    public void onLoc(View view){
        Intent intentToLocs = new Intent(NavigationActivity.this, LocationActivity.class);
        startActivity(intentToLocs);
    }


}//end of the class