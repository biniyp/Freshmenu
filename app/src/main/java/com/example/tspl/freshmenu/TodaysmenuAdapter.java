package com.example.tspl.freshmenu;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tspl on 21-06-2016.
 */
public class TodaysmenuAdapter extends RecyclerView.Adapter<TodaysmenuAdapter.ViewHolder> {

    private  List<TodaysmenuData> datas;
    private InteractionListener interactionListener;
    private View view;
    private TodaysmenuData todaysmenuData;
    int clicked = 0;
    private Context context;
    private int[] clickedcount = {0,0,0};
    private Todaysdata todaysdata;


    public TodaysmenuAdapter(List<TodaysmenuData> datas,InteractionListener interactionListener){
        this.datas = datas;
        this.interactionListener = interactionListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todays_menus_cardview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final TodaysmenuAdapter.ViewHolder holder, final int position) {
        todaysmenuData = datas.get(position);
        holder.title.setText(todaysmenuData.getTitle());
        holder.price.setText("₹ "+todaysmenuData.getPrice());
        holder.backimage.setImageResource(todaysmenuData.getBackimage());
        holder.desc.setText(todaysmenuData.getDetails());
        holder.title1.setText(todaysmenuData.getTitle());
        if(holder.noofitems.getVisibility() == view.VISIBLE)
        {
            Integer[] qtyarray = Items.getInstance().getQuanities();
            String qty = String.valueOf(qtyarray[position]);
            holder.noofitems.setText(qty);
        }
        //int noitems = Integer.parseInt(holder.noofitems.getText().toString());

        holder.plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int noitems = clickedcount[position];
                clicked = noitems;
                clicked = clicked+1;
                clickedcount[position] = clicked;
                Items.getInstance().setItempos(position,position);
                Items.getInstance().setQuanities(clicked,position);
                //Items.getInstance().setItemnames(todaysdata.titlearray[position],position);
                //Items.getInstance().setCart(holder.title.getText().toString(),holder.price.getText().toString(),qty,holder.backimage.getDrawable());
                //Log.d("hi","hi"+ Arrays.toString(clickedcount));
                if(holder.noofitems.getVisibility() != view.VISIBLE)
                {
                    holder.noofitems.setVisibility(view.VISIBLE);
                }
                if(holder.minusbtn.getVisibility() != view.VISIBLE)
                {
                    holder.minusbtn.setVisibility(view.VISIBLE);
                }
                holder.noofitems.setText(String.valueOf(clicked));
                interactionListener.onViewClicked(position,clicked);
            }
        });
        holder.minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked > 0)
                {
                    int noitems = clickedcount[position];
                    clicked = noitems;
                    clicked = clicked-1;
                    clickedcount[position] = clicked;
                    if(clicked == 0)
                    {
                        if(holder.noofitems.getVisibility() == view.VISIBLE)
                        {
                            int asgnzero = 0;
                            holder.noofitems.setText(String.valueOf(asgnzero));
                            holder.noofitems.setVisibility(view.GONE);
                        }
                        if(holder.minusbtn.getVisibility() == view.VISIBLE)
                        {
                            holder.minusbtn.setVisibility(view.GONE);
                        }
                    }
                }
                else
                {
                    if(holder.noofitems.getVisibility() == view.VISIBLE)
                    {
                        int asgnzero = 0;
                        holder.noofitems.setText(String.valueOf(asgnzero));
                        holder.noofitems.setVisibility(view.GONE);
                    }
                    if(holder.minusbtn.getVisibility() == view.VISIBLE)
                    {
                        holder.minusbtn.setVisibility(view.GONE);
                    }
                }
                holder.noofitems.setText(String.valueOf(clicked));
            }
        });
        holder.ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.detaileddes.getVisibility() != v.VISIBLE)
                {
                    holder.detaileddes.setVisibility(v.VISIBLE);
                }
            }
        });
        holder.closedesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.detaileddes.getVisibility() == v.VISIBLE)
                {
                    holder.detaileddes.setVisibility(v.GONE);
                }
            }
        });
        if(clicked > 0)
        {
            if(holder.noofitems.getVisibility() != view.VISIBLE)
            {
                holder.noofitems.setVisibility(view.VISIBLE);
            }
            if(holder.minusbtn.getVisibility() != view.VISIBLE)
            {
                holder.minusbtn.setVisibility(view.VISIBLE);
            }
        }
        else
        {
            if(holder.noofitems.getVisibility() == view.VISIBLE)
            {
                holder.noofitems.setVisibility(view.GONE);
            }
            if(holder.minusbtn.getVisibility() == view.VISIBLE)
            {
                holder.minusbtn.setVisibility(view.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //RelativeLayout parentLayout;
        public CardView parentLayout;
        public TextView title;
        public TextView price;
        public ImageView backimage;
        public TextView noofitems;
        public Button plusbtn;
        public Button minusbtn;
        public TextView desc;
        public TextView title1;
        public Button ibtn;
        public LinearLayout detaileddes;
        public Button closedesc;
        public ViewHolder(View itemView) {
            super(itemView);
            parentLayout = (CardView) view.findViewById(R.id.parentLayout);
            title = (TextView) view.findViewById(R.id.productname);
            price = (TextView) view.findViewById(R.id.price);
            backimage = (ImageView) view.findViewById(R.id.bakimg);
            noofitems = (TextView) view.findViewById(R.id.pricevalue);
            plusbtn = (Button) view.findViewById(R.id.plusid);
            minusbtn = (Button) view.findViewById(R.id.minusid);
            desc    =   (TextView) view.findViewById(R.id.product_desc);
            title1 = (TextView) view.findViewById(R.id.title1);
            ibtn = (Button) view.findViewById(R.id.ibutton);
            detaileddes = (LinearLayout) view.findViewById(R.id.detailview);
            closedesc = (Button) view.findViewById(R.id.closebtn);
        }
    }
    public interface InteractionListener {
        void onViewClicked(int position,int qty);
    }
}