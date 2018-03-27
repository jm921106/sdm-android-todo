package com.todo.sdm.sdm_android_todo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> arrayList;
    OnItemClickListener onItemClickListener;
    OnItemLongClickListener onItemLongClickListener;
    private Context context;

    // [#] constructor 1
    public BaseAdapter(Context context) {
        this.context = context;
    }

    // [#] constructor 2
    public BaseAdapter(Context context, List<T> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    // [#]
    public Context getContext() {
        return context;
    }

    // @DES :: 전체 아이템 갯수 얻기
    @Override
    public int getItemCount() {
        if (arrayList == null)
            return 0;
        return arrayList.size();
    }

    // @DES :: index 아이템 얻기
    public T getItem(int position) {
        if (arrayList == null)
            return null;
        return arrayList.get(position);
    }

    // @DES ::
    public void updateItems(List<T> items) {
        if (this.arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.arrayList.clear();
        this.arrayList.addAll(items);
        notifyDataSetChanged();
    }

    // @DES ::
    public void addItems(List<T> items) {
        if (this.arrayList == null) {
            this.arrayList = items;
        } else {
            this.arrayList.addAll(items);
        }
        notifyDataSetChanged();
    }

    // @DES ::
    public void clearItems() {
        if (arrayList != null) {

            arrayList.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(holder.itemView, position);
                }

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClick(holder.itemView, position);
                }

                return false;
            }
        });

        onBindView((H) holder, position);
    }

    abstract public void onBindView(H holder, int position);

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        public void onItemLongClick(View view, int position);
    }

}
