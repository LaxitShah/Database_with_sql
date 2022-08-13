package com.example.database_with_sql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends BaseAdapter {

    Context context;
    ArrayList<ContactModel> contactModelArrayList;

    public DataAdapter(Context context,ArrayList<ContactModel> contactModelArrayList)
    {
        this.context=context;
        this.contactModelArrayList=contactModelArrayList;
    }

    @Override
    public int getCount() {
        return contactModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.raw_list,null);

        TextView tvData1=convertView.findViewById(R.id.tv_data1);
        TextView tvData2=convertView.findViewById(R.id.tv_data2);
        ContactModel contactModel= contactModelArrayList.get(position);

        tvData1.setText(contactModel.getFirstName());
        tvData2.setText(contactModel.getLastName());

    return convertView;
    }
}
