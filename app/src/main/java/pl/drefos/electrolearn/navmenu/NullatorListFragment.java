package pl.drefos.electrolearn.navmenu;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import pl.drefos.electrolearn.MainActivity;
import pl.drefos.electrolearn.dictionary.DataBase;

public class NullatorListFragment extends ListFragment {

    private DataBase data;
    private OnNullerClick nullerClick;
    private int suprise=0;

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
        if(position==1) {
            suprise++;
        }
        if(position>1) {
            MainActivity.nullerId = position;
            nullerClick.nullClick();
        }
        if(suprise==3) {
            suprise=0;
            Toast.makeText(getActivity(), "Dwójnikiem nazywamy element bądź elementy wczepione między dwa zaciski.", Toast.LENGTH_LONG).show();
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
