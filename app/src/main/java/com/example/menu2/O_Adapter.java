package com.example.menu2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class O_Adapter extends RecyclerView.Adapter<O_Adapter.orderViewHolder> {

    private Context mContext;
    private ArrayList<canteen> orderList;


    public O_Adapter(Context mContext, ArrayList<canteen> orderList) {
        this.mContext = mContext;
        this.orderList = orderList;
    }

    @Override
    public O_Adapter.orderViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.roview, null);

        return new orderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final orderViewHolder holder,final int position) {
        if (Integer.parseInt(orderList.get(position).getQuantity()) != 0) {
            holder.items.setText(orderList.get(position).getItems());
            holder.quantity.setText(orderList.get(position).getQuantity());
        }
        else {
            holder.items.setText("");
            holder.quantity.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class orderViewHolder extends RecyclerView.ViewHolder {
        public TextView items;
        public TextView quantity;

        public orderViewHolder(View itemView) {
            super(itemView);
            items = (TextView) itemView.findViewById(R.id.textView3);
            quantity = (TextView) itemView.findViewById(R.id.quantitytextview);
        }
    }
}
