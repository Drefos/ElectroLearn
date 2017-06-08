package pl.drefos.electrolearn.navmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pl.drefos.electorlearn.R;

/**
 * Created by Maciek on 2017-05-05.
 */

public class FirstPageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_view, container, false);
    }

}
