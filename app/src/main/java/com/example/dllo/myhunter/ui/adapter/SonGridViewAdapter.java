package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.dllo.myhunter.R;

import java.util.List;

/**
 * Created by dllo on 16/8/18.
 */
public class SonGridViewAdapter extends BaseAdapter {
    private List<String> data;
    private Context context;

    public SonGridViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewHolder gridViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent, false);
            gridViewHolder = new GridViewHolder(convertView);
            convertView.setTag(gridViewHolder);
        } else {
            gridViewHolder = (GridViewHolder) convertView.getTag();
        }

        gridViewHolder.button.setText(data.get(position));
        return convertView;
    }

    class GridViewHolder {
        private Button button;

        public GridViewHolder(View view) {
            button = (Button) view.findViewById(R.id.domestic_city_hot_btn);
        }
    }
}
