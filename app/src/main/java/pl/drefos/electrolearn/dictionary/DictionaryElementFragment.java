package pl.drefos.electrolearn.dictionary;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.drefos.electorlearn.R;

/**
 * Created by Maciek on 2017-05-13.
 */

public class DictionaryElementFragment extends Fragment {

    private LoadDictionaryElement loadDictionaryElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loadDictionaryElement = (LoadDictionaryElement) getActivity();
        return inflater.inflate(R.layout.dictionary_element, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadDictionaryElement.load();
    }


    public interface LoadDictionaryElement {
        void load();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        loadDictionaryElement = null;
    }
}
