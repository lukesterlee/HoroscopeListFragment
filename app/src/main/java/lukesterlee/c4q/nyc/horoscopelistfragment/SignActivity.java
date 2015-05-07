package lukesterlee.c4q.nyc.horoscopelistfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by Luke on 5/7/2015.
 */
public class SignActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallBack {

    static int mCurrentPosition = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_description);
        int position = getIntent().getExtras().getInt("position");

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt("position");
        }

        TextView text = (TextView) findViewById(R.id.textDescription);
        text.setText(Data.description[position]);
        mCurrentPosition = position;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", mCurrentPosition);
    }

    @Override
    public void onNavigationItemSelected(int position) {

    }
}
