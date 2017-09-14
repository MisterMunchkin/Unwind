package com.unwind.munchkin.unwind;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Munchkin on 9/4/2017.
 */

public class launchingPageTab3Fragment extends Fragment{
    private static final String TAG = "Tab3Fragment";

    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.launchingpagetab3fragment, container,false);
        btnTEST = (Button)view.findViewById(R.id.btnTEST3);

        return view;
    }
}
