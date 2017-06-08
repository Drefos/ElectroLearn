package pl.drefos.electrolearn;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import pl.drefos.electorlearn.R;

/**
 * Created by Maciek on 2017-05-08.
 */

public class FirstStartDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.hello_title);
        builder.setMessage(R.string.hello_message);
        builder.setPositiveButton("Start!", null);
        return builder.create();
    }
}
