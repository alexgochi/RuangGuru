package alexgochi.ruangguru.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import alexgochi.ruangguru.R;
import alexgochi.ruangguru.SessionHandler;
import alexgochi.ruangguru.User;
import alexgochi.ruangguru.fragment.AccountFragment;
import alexgochi.ruangguru.fragment.HomeFragment;
import alexgochi.ruangguru.fragment.OtherFragment;
import alexgochi.ruangguru.fragment.PurchaseFragment;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {
    private SessionHandler session;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionHandler(getApplicationContext());
        user = session.getUserDetails();

        loadFragment(new HomeFragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_purchased:
                fragment = new PurchaseFragment();
                break;
            case R.id.navigation_account:
                fragment = new AccountFragment();
                break;
            case R.id.navigation_other:
                fragment = new OtherFragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
