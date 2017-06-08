package pl.drefos.electrolearn;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.drefos.electorlearn.R;

/**
 * Created by Maciek on 2017-06-08.
 */

public class ACFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_view_2, container, false);
    }
}
