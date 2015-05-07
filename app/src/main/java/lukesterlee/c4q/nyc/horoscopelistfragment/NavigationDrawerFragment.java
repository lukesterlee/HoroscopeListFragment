package lukesterlee.c4q.nyc.horoscopelistfragment;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.app.ActionBar;
import android.support.v4.app.ActionBarDrawerToggle;


public class NavigationDrawerFragment extends Fragment {

    private ListView mDrawerListView;
    private boolean mUserLearnedDrawer;
    private int mCurrentPosition = 0;

    NavigationDrawerCallBack mActivityCallBack;

    public interface NavigationDrawerCallBack {
        void onNavigationItemSelected(int position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean("navigation_drawer_learned", false);


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mActivityCallBack = (NavigationDrawerCallBack) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " didn't implement NavigationDrawerCallBack interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mDrawerListView = (ListView) inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Data.menus);
        mDrawerListView.setAdapter(adapter);
        mDrawerListView.setItemChecked(mCurrentPosition, true);
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });
        return mDrawerListView;


    }

    public void selectItem(int position) {
        mCurrentPosition = position;
        mActivityCallBack.onNavigationItemSelected(position);
    }


}
