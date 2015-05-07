package lukesterlee.c4q.nyc.horoscopelistfragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;


public class MainActivity extends ActionBarActivity implements SignFragment.OnSignSelectedListener, NavigationDrawerFragment.NavigationDrawerCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            SignFragment signArgument = new SignFragment();

            signArgument.setArguments(getIntent().getExtras());


            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, signArgument).commit();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onSignSelected(int position) {

        Intent sign = new Intent(getApplicationContext(), SignActivity.class);
        sign.putExtra("position", position);
        startActivity(sign);


//        DescriptionFragment description = new DescriptionFragment();
//        Bundle argument = new Bundle();
//        argument.putInt(DescriptionFragment.POSITION, position);
//        description.setArguments(argument);
//
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//        transaction.replace(R.id.fragment_container, description);
//        transaction.addToBackStack(null);
//        transaction.commit();


    }


    @Override
    public void onNavigationItemSelected(int position) {

    }
}
