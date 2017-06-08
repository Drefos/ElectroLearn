package pl.drefos.electrolearn.navmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pl.drefos.electorlearn.R;

/**
 * Created by Maciek on 2017-05-05.
 */

public class AboutAppFragment extends Fragment {

    private LoadFab fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fab = (LoadFab) getActivity();
        return inflater.inflate(R.layout.info, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        fab.loadFab();
    }

    public interface LoadFab {
        void loadFab();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fab = null;
    }
}
