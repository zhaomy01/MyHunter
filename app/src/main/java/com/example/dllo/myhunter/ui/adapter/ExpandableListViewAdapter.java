package com.example.dllo.myhunter.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.AllCityBean;
import com.example.dllo.myhunter.ui.activity.MainActivity;
import com.example.dllo.myhunter.view.MyGridView;

import java.util.List;


public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private AllCityBean father;

    public ExpandableListViewAdapter(Context context) {
        this.context = context;
    }

    public void setFather(AllCityBean father) {
        this.father = father;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return father.getCity_data().getOversea_city().getAll_city_list().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return father.getCity_data().getOversea_city().getAll_city_list().get(groupPosition).getChildren().size() == 0 ? 0 : 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return father.getCity_data().getOversea_city().getAll_city_list().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return father.getCity_data().getOversea_city().getAll_city_list().get(groupPosition).getChildren();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        FatherHolder fatherHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_verticallistview, parent, false);
            fatherHolder = new FatherHolder(convertView);
            convertView.setTag(fatherHolder);
        } else {
            fatherHolder = (FatherHolder) convertView.getTag();
        }
        fatherHolder.textView.setText(father.getCity_data().getOversea_city().getAll_city_list().get(groupPosition).getName());
        fatherHolder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String cname =father.getCity_data().getOversea_city().getAll_city_list().get(groupPosition).getName();
                SharedPreferences.Editor editor = context.getSharedPreferences("city",Context.MODE_PRIVATE).edit();
                editor.putString("str",cname);
                editor.commit();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                ((Activity) context).finish();
                return true;
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SonHolder sonHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_child, parent, false);
            sonHolder = new SonHolder(convertView);
            convertView.setTag(sonHolder);
        } else {
            sonHolder = (SonHolder) convertView.getTag();

        }
        List<String> sonDatas = (List<String>) getChild(groupPosition, childPosition);
        SonGridViewAdapter sonGridViewAdapter = new SonGridViewAdapter(context);
        sonGridViewAdapter.setData(sonDatas);
        sonHolder.gridView.setAdapter(sonGridViewAdapter);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class FatherHolder {
        private TextView textView;

        public FatherHolder(View view) {
            textView = (TextView) view.findViewById(R.id.domestic_city_all_tv);
        }
    }

    class SonHolder {
        private MyGridView gridView;

        public SonHolder(View view) {
            gridView = (MyGridView) view.findViewById(R.id.gridview_child);
        }
    }
}
