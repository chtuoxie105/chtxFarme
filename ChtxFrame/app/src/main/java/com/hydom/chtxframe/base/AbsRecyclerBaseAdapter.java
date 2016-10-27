package com.hydom.chtxframe.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/21.
 */
public abstract class AbsRecyclerBaseAdapter<K> extends RecyclerView.Adapter{
    private ArrayList<K> dataList = new ArrayList<>();
    private Context context;
    public AbsRecyclerBaseAdapter(Context context){
        this.context =context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(getLayoutResourcesId(),null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        initsView((MyHolder) holder,position,dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    protected abstract int getLayoutResourcesId();
    protected abstract void initsView(MyHolder holder,int position,K data);

    public class MyHolder extends RecyclerView.ViewHolder{
        private  SparseArray sparseArray = new SparseArray();
        private View itemsView;
        public MyHolder(View itemView) {
            super(itemView);
            itemsView =itemView;
        }
        public TextView getTextView(int id){
            TextView textView = null;
            if(sparseArray.get(id)==null){
                textView = (TextView) itemsView.findViewById(id);
                sparseArray.put(id,textView);
            }else{
                textView = (TextView) sparseArray.get(id);
            }
            return textView;
        }
        public Button getButton(int id){
            Button btn = null;
            if(sparseArray.get(id)==null){
                btn = (Button) itemsView.findViewById(id);
                sparseArray.put(id,btn);
            }else{
                btn = (Button) sparseArray.get(id);
            }
            return btn;
        }
        public ImageView getImageView(int id){
            ImageView imageView = null;
            if(sparseArray.get(id)==null){
                imageView = (ImageView) itemsView.findViewById(id);
                sparseArray.put(id,imageView);
            }else{
                imageView = (ImageView) sparseArray.get(id);
            }
            return imageView;
        }
    }
}
