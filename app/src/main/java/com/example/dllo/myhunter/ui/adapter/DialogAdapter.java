package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.myhunter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题Dialog适配器
 */
public class DialogAdapter extends BaseAdapter {
    private Context context;
    private String[] titles;
    private List<String> data = new ArrayList<>();

    public DialogAdapter(Context context, String[] titles) {
        this.context = context;
        this.titles = titles;
        for (int i = 0; i < titles.length; i++) {
            String s = new String(titles[i]);
            data.add(s);
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.itme_dialog,parent,false);
        TextView textView = (TextView) view.findViewById(R.id.itme_dialog_tv);
        textView.setText(data.get(position));
        return view;
    }
}
