package com.yash.vugstech;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class because this dialog has a simple UI
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("We have something for you!").setPositiveButton("SHOW", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(getResources().getString(R.string.dialog_message));

            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {

                // Nothing happening here either
            }
        });

// Create the object and return it
        return builder.create();
    }// End onCreateDialog

}

