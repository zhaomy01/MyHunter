package com.example.dllo.myhunter.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.AllCityBean;
import com.example.dllo.myhunter.ui.activity.MainActivity;
import com.example.dllo.myhunter.ui.fragment.DomesticFragment;
import com.example.dllo.myhunter.ui.fragment.RecommendedFragment;

import java.io.UnsupportedEncodingException;

/**
 * Created by dllo on 16/8/18.
 */
public class DomesticAdapter extends BaseAdapter {
    private AllCityBean data;
    private Context context;
    private int type;

    public DomesticAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    public void setData(AllCityBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (type == 0) {
            return data != null ? data.getCity_data().getDomestic_city().getHot_city_list().size() : 0;
        } else if (type == 1) {
            return data != null ? data.getCity_data().getDomestic_city().getAll_city_list().size() : 0;
        } else {
            return data != null ? data.getCity_data().getOversea_city().getHot_city_list().size() : 0;
        }
    }

    @Override
    public Object getItem(int position) {
        if (type == 0) {
            return data.getCity_data().getDomestic_city().getHot_city_list().get(position);
        } else if (type == 1) {
            return data.getCity_data().getDomestic_city().getAll_city_list().get(position);
        } else {
            return data.getCity_data().getOversea_city().getHot_city_list().get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (type == 0) {
            DomesticHotHolder domesticHotHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent, false);
                domesticHotHolder = new DomesticHotHolder(convertView);
                convertView.setTag(domesticHotHolder);

            } else {
                domesticHotHolder = (DomesticHotHolder) convertView.getTag();
            }
            domesticHotHolder.button.setText(data.getCity_data().getDomestic_city().getHot_city_list().get(position));
        } else if (type == 1) {
            DomesticAllHolder domesticAllHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_verticallistview, parent, false);
                domesticAllHolder = new DomesticAllHolder(convertView);
                convertView.setTag(domesticAllHolder);

            } else {
                domesticAllHolder = (DomesticAllHolder) convertView.getTag();
            }
            domesticAllHolder.textView.setText(data.getCity_data().getDomestic_city().getAll_city_list().get(position).getName());

        } else if (type == 2) {
            OverSeaHotHolder overSeaHotHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent, false);
                overSeaHotHolder = new OverSeaHotHolder(convertView);
                convertView.setTag(overSeaHotHolder);
            } else {
                overSeaHotHolder = (OverSeaHotHolder) convertView.getTag();
            }
            overSeaHotHolder.button.setText(data.getCity_data().getOversea_city().getHot_city_list().get(position));
        }
        return convertView;
    }

    class DomesticHotHolder {
        private Button button;

        public DomesticHotHolder(View view) {
            button = (Button) view.findViewById(R.id.domestic_city_hot_btn);

        }
    }

    class DomesticAllHolder {
        private TextView textView;

        public DomesticAllHolder(View view) {
            textView = (TextView) view.findViewById(R.id.domestic_city_all_tv);
        }

    }

    class OverSeaHotHolder {
        private Button button;

        public OverSeaHotHolder(View view) {
            button = (Button) view.findViewById(R.id.domestic_city_hot_btn);

        }
    }

}
