package com.example.tspl.freshmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart extends AppCompatActivity {

    private View view;
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<CartData> cartDatas = new ArrayList<>();
    int totalqty,totalprice;
    private TextView textView1,textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.secrecyclerview);
        cartAdapter = new CartAdapter(cartDatas);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cartAdapter);
        //Intent intent = getIntent();
        //int intValue = intent.getIntExtra("pos",1);
        //int qty = intent.getIntExtra("qty",1);
        //String qty1 = String.valueOf(qty);
        //Log.d("hi","hi"+qty);
        Todaysdata todaysdata = new Todaysdata();
        Integer arrlength = (Integer)  Items.getInstance().getQuanities().length;
        Integer[] arr1 = Items.getInstance().getQuanities();
        Integer[] arr2 = Items.getInstance().getItempos();
        for(int i=0;i<arrlength;i++)
        {
            if(arr1[i] != 0)
            {
                int pos = arr2[i];
                String qty1 = String.valueOf(arr1[i]);
                CartData cartData = new CartData(todaysdata.titlearray[pos],todaysdata.pricearray[pos],qty1,todaysdata.bakimages[pos],todaysdata.productid[pos]);
                cartDatas.add(cartData);
                totalqty = totalqty+arr1[i];
                totalprice = totalprice+Integer.valueOf(todaysdata.pricearray[pos]);
            }
        }
        textView1 = (TextView) findViewById(R.id.totqty);
        textView2 = (TextView) findViewById(R.id.totprice);
        textView1.setText(String.valueOf(totalqty));
        textView2.setText("₹"+String.valueOf(totalprice));
    }
}
