package com.example.tspl.freshmenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tspl on 05-07-2016.
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private List<CartData> cartDatas;
    private CartData cartData;
    private View view;

    public CartAdapter(List<CartData> cartDataList){
        this.cartDatas = cartDataList;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_cart,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CartAdapter.ViewHolder holder, final int position) {
        cartData = cartDatas.get(position);
        holder.productname.setText(cartData.getTitlepdt());
        holder.quantity.setText(cartData.getQty());
        holder.amount.setText("₹ "+cartData.getPrice());
        holder.imageView.setImageResource(cartData.getImg());
        holder.prdctid.setText(String.valueOf(cartData.getPid()));
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer qty[];
                Integer pos = Integer.valueOf(String.valueOf(holder.prdctid.getText()));
                holder.hiddenid.setText(String.valueOf(pos));
                pos = pos-1;
                qty = Items.getInstance().getQuanities();
                int quantity = qty[pos];
                holder.countview.setText(String.valueOf(quantity));
                //Log.d("hi","hi"+ quantity);
            }
        });
        holder.plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        holder.deletbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LinearLayout layout = (LinearLayout) v.findViewById(R.id.selectionlayout);
//                layout.setVisibility(View.GONE);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return  cartDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout relativeLayout;
        public ImageView imageView;
        public TextView productname;
        public TextView quantity;
        public TextView amount;
        public TextView edit;
        public ImageButton deletbtn;
        public TextView prdctid;
        public LinearLayout linearLayout;
        public TextView countview;
        public TextView hiddenid;
        public ImageButton plusbtn;
        public ImageButton minusbtn;
        public ViewHolder(View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.mainlayout);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            productname = (TextView) itemView.findViewById(R.id.productname);
            quantity = (TextView) itemView.findViewById(R.id.showprice);
            amount = (TextView) itemView.findViewById(R.id.amount);
            edit = (TextView) itemView.findViewById(R.id.edittext);
            deletbtn = (ImageButton) itemView.findViewById(R.id.deletebtn);
            prdctid = (TextView) itemView.findViewById(R.id.productid);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.selectionlayout);
            countview = (TextView) itemView.findViewById(R.id.countview);
            hiddenid = (TextView) itemView.findViewById(R.id.hiddenid);
            plusbtn = (ImageButton) itemView.findViewById(R.id.plusbtn);
            minusbtn = (ImageButton) itemView.findViewById(R.id.minusbtn);
        }
    }
}