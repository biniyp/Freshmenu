package com.example.tspl.freshmenu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class TodaysMenu extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private RecyclerView recyclerView;
    private TodaysmenuAdapter todaysmenuAdapter;
    private Context context;
    private List<TodaysmenuData> datas = new ArrayList<>();


    public TodaysMenu() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TodaysMenu newInstance(String param1, String param2) {
        TodaysMenu fragment = new TodaysMenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_todays_menu, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        todaysmenuAdapter = new TodaysmenuAdapter(datas,new TodaysmenuAdapter.InteractionListener(){
            public void onViewClicked(int position,int itemcount)
            {
                //Log.d("hi","hi");
                Intent intent = new Intent(getActivity(),Cart.class);
                intent.putExtra("pos",position);
                intent.putExtra("qty",itemcount);
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(todaysmenuAdapter);
        Todaysdata todaysdata = new Todaysdata();
        Integer arrlength = (Integer) todaysdata.titlearray.length;
        //int arrsize = todatsdata.titlearray.length;
        //todatsdata.titlearray.length;
        for (int i=0;i<arrlength;i++){
            //TodaysmenuData todatas = new TodaysmenuData(todatsdata.titlearray[i],todatsdata.pricearray[i]);
            TodaysmenuData todatas = new TodaysmenuData(todaysdata.titlearray[i],todaysdata.pricearray[i],todaysdata.bakimages[i],todaysdata.desc[i]);
            //TodaysmenuData todatas = new TodaysmenuData("gsg","$100");
            //mainlayout

            datas.add(todatas);
        }
        return view;
    }
}
