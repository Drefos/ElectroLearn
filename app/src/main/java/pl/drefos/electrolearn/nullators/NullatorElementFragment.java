package pl.drefos.electrolearn.nullators;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.drefos.electorlearn.R;
import pl.drefos.electrolearn.dictionary.DictionaryElementFragment;

/**
 * Created by Maciek on 2017-06-07.
 */

public class NullatorElementFragment extends Fragment {

    private LoadNullatorElement loadNullatorElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loadNullatorElement = (LoadNullatorElement) getActivity();
        return inflater.inflate(R.layout.nullator_element, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadNullatorElement.loadNullers();
    }


    public interface LoadNullatorElement {
        void loadNullers();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        loadNullatorElement = null;
    }
}
