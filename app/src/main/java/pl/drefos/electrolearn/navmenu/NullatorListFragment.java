package pl.drefos.electrolearn.navmenu;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pl.drefos.electrolearn.MainActivity;
import pl.drefos.electrolearn.dictionary.DataBase;

public class NullatorListFragment extends ListFragment {

    private DataBase data;
    private OnNullerClick nullerClick;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = MainActivity.dataBase;
        nullerClick = (OnNullerClick) getActivity();
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, data.getNullators()));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(position>1) {
            MainActivity.nullerId = position;
            nullerClick.nullClick();
        }
    }

    public interface OnNullerClick {
        void nullClick();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        data=null;
        nullerClick=null;
    }
}
