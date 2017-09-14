package com.unwind.munchkin.unwind;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Munchkin on 9/4/2017.
 */

public class launchingPageTab2Fragment extends Fragment{
    private static final String TAG = "Tab2Fragment";


    LinearLayout currentDiv; //current
    LinearLayout historyDiv; //history
    FloatingActionButton FAB;

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapter adapter;
    private List<currentBooking> data_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.launchingpagetab2fragment, container,false);


        currentDiv = (LinearLayout) view.findViewById(R.id.Current_Div);
        historyDiv = (LinearLayout) view.findViewById(R.id.History_Div);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                view.findViewById(R.id.bottom_navigation);

        FAB = (FloatingActionButton) view.findViewById(R.id.AddBookingFAB);

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddBookingPage.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Current:
                        currentDiv.setVisibility(View.VISIBLE);
                        historyDiv.setVisibility(View.GONE);
                        break;
                    case R.id.History:
                        historyDiv.setVisibility(View.VISIBLE);
                        currentDiv.setVisibility(View.GONE);
                        break;
                }
                return true;
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.currentBooking_recyclerView);
        data_list = new ArrayList<>();
       // load_data_from_server(0);

        gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new CustomAdapter(getActivity(),data_list);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if(gridLayoutManager.findLastCompletelyVisibleItemPosition() == data_list.size() - 1){
                    //load_data_from_server(data_list.get(data_list.size()-1).getId());
                }
            }
        });

        return view;
    }
/*
    private void load_data_from_server(final int id){//error here java.lang.runtime exception
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("localhost:1337/Unwind/fetchCurrentBooking.php?id="+id)
                        .build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for(int i = 0; i < array.length();i++){
                        JSONObject object = array.getJSONObject(i);

                        currentBooking booking = new currentBooking(object.getInt("bookingID"),
                                object.getString("checkin"), object.getString("checkout"));


                        data_list.add(booking);
                    }
                }catch(IOException e){
                    Toast.makeText(getActivity(), "something wrong with database",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }catch(JSONException e){
                    System.out.println("End of content");
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged(); //https://www.youtube.com/watch?v=xtVHvifaKC4
            }
        };
        task.execute(id);
    }*/
}
