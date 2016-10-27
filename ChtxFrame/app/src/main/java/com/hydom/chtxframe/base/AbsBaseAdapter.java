package com.hydom.chtxframe.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/21.
 */
public abstract class AbsBaseAdapter<K> extends BaseAdapter {
    private ArrayList<K> dataList = new ArrayList<>();
    private Context context;

    public AbsBaseAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AbsViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getResourcesId(), null);
            holder = new AbsViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (AbsViewHolder) convertView.getTag();
        }
        initsView(holder, dataList.get(position), position);
        return convertView;
    }

    protected abstract int getResourcesId();

    protected abstract void initsView(AbsViewHolder holder, K data, int position);

    public class AbsViewHolder {
        private SparseArray sparseArray = new SparseArray();
        private View itemView;

        public AbsViewHolder(View view) {
            itemView = view;
        }

        public TextView getTextView(int id) {
            TextView textView = null;
            if (sparseArray.get(id) == null) {
                textView = (TextView) itemView.findViewById(id);
                sparseArray.put(id, textView);
            } else {
                textView = (TextView) sparseArray.get(id);
            }
            return textView;
        }
        public Button getButton(int id){
            Button btn = null;
            if(sparseArray.get(id)==null){
                btn = (Button) itemView.findViewById(id);
                sparseArray.put(id,btn);
            }else{
                btn = (Button) sparseArray.get(id);
            }
            return btn;
        }
        public ImageView getImageView(int id){
            ImageView imageView = null;
            if(sparseArray.get(id)==null){
                imageView = (ImageView) itemView.findViewById(id);
                sparseArray.put(id,imageView);
            }else{
                imageView = (ImageView) sparseArray.get(id);
            }
            return imageView;
        }
    }
}
