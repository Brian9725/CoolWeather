package com.coolweather.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coolweather.android.R;

import java.util.List;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder> {

    private List<String> stringList;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View areaView;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            areaView = view;
            textView = view.findViewById(R.id.area_name);
        }
    }

    public AreaAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.areaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(holder.areaView, holder.getAdapterPosition());
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String areaName = stringList.get(position);
        holder.textView.setText(areaName);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
