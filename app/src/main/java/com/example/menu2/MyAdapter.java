package com.example.menu2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.canteenViewHolder> {
    private Context mContext;
    public ArrayList<canteen> foodList;
    public String a;
    public String b;

    public MyAdapter(Context mContext, ArrayList<canteen> foodList) {
        this.mContext = mContext;
        this.foodList = foodList;
    }


    @Override
    public canteenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.list, null);
        canteenViewHolder vh = new canteenViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(final canteenViewHolder holder, final int position) {
        holder.items.setText(foodList.get(position).getItems());
        holder.description.setText(foodList.get(position).getDescription());
        holder.price.setText(foodList.get(position).getPrice());
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(foodList.get(position).getImage()));
        holder.editText.setFilters(new InputFilter[]{new MainActivity.Inputfilter()});
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class canteenViewHolder extends RecyclerView.ViewHolder {
        public TextView items;
        public TextView description;
        public TextView price;
        public EditText editText;
        public ImageView imageView;
        public ArrayList<order> orderList;
        order o;

        public canteenViewHolder(View view) {
            super(view);
            items = (TextView) view.findViewById(R.id.ItemsTextView);
            description = (TextView) view.findViewById(R.id.DescriptionTextView);
            price = (TextView) view.findViewById(R.id.priceTextView);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            editText = (EditText) view.findViewById(R.id.editText);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    foodList.get(getAdapterPosition()).setQuantity(s.toString());

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}