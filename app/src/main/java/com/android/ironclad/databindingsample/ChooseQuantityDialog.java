package com.android.ironclad.databindingsample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.android.ironclad.databindingsample.databinding.DialogChooseQuantityBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ChooseQuantityDialog extends DialogFragment {

    private static final String TAG = "ChooseQuantityDialog";
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d(TAG, "onItemSelected: selected: " + adapterView.getItemAtPosition(i));

            IMainActivity iMainActivity = (IMainActivity) getActivity();
            iMainActivity.chooseQuantity(Integer.parseInt((String) adapterView.getItemAtPosition(i)));

            getDialog().dismiss();
        }
    };
    private View.OnClickListener mCloseDialogListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getDialog().dismiss();
        }
    };

    // Data binding
    private DialogChooseQuantityBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = DialogChooseQuantityBinding.inflate(inflater);
        mBinding.listView.setOnItemClickListener(mOnItemClickListener);
        mBinding.closeDialog.setOnClickListener(mCloseDialogListener);

        return mBinding.getRoot();
    }
}