package pl.drefos.electrolearn.navmenu;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pl.drefos.electrolearn.MainActivity;
import pl.drefos.electrolearn.dictionary.DataBase;

public class DictionaryListFragment extends ListFragment {

    private OnItemClicked onItemClicked;
    private DataBase data;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = MainActivity.dataBase;
        onItemClicked = (OnItemClicked) getActivity();
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, data.getDictionary()));
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        if(position>1) {
            MainActivity.dictionaryItemId = position;
            onItemClicked.click();
        }

    }

    public interface OnItemClicked{
        void click();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onItemClicked = null;
        data = null;
    }
}
