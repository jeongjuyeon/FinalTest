package com.example.a502_29pc.finaltest.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a502_29pc.finaltest.R;
import com.example.a502_29pc.finaltest.datas.Store;

import java.util.List;

public class StoreAdapter extends ArrayAdapter<Store> {

    Context mContext;
    List<Store> mList;
    LayoutInflater inf;

    public StoreAdapter(Context mContext, List<Store> mList) {
        super(mContext, R.layout.store_list_item, mList);

        this.mContext = mContext;
        this.mList = mList;
        this.inf = LayoutInflater.from(mContext);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.store_list_item, null);
        }

        ImageView logoImg = row.findViewById(R.id.logoImg);
        TextView nameTxt = row.findViewById(R.id.nameTxt);

        final Store data = mList.get(position);

        Glide.with(mContext).load(data.getLogo()).into(logoImg);
        nameTxt.setText(data.getName());

        return row;

    }
}
