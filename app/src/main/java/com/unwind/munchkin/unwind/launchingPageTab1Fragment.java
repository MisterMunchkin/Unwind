package com.unwind.munchkin.unwind;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Munchkin on 9/4/2017.
 */

public class launchingPageTab1Fragment extends Fragment{
    private static final String TAG = "Tab1Fragment";
    private Button servicesBtn;

   // private Button btnTEST;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.launchingpagetab1fragment, container,false);

        servicesBtn = (Button) view.findViewById(R.id.servicesButton);

        servicesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "start services list activity",
                        Toast.LENGTH_LONG).show();
            }
        });
       /* recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_active_checkin);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
*/
        return view;
    }
}
