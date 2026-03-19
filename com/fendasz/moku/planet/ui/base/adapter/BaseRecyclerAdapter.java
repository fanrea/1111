package com.fendasz.moku.planet.ui.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {
    private OnItemClickListener mClickListener;
    public final Context mContext;
    private List<T> mData;
    private OnItemLongClickListener mLongClickListener;
    private String tag;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int i);
    }

    public abstract void bindData(RecyclerViewHolder recyclerViewHolder, int i, T t);

    public abstract int getItemLayoutId(int i);

    public abstract void notifyDataInit();

    public BaseRecyclerAdapter(Context context, List<T> list) {
        ArrayList arrayList = new ArrayList();
        this.mData = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.mContext = context;
    }

    public void setData(List<T> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataInit();
        notifyDataSetChanged();
    }

    public void remove(int i) {
        this.mData.remove(i);
        notifyItemRemoved(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate(getItemLayoutId(i), viewGroup, false));
        if (this.mClickListener != null) {
            recyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseRecyclerAdapter.this.mClickListener.onItemClick(recyclerViewHolder.itemView, recyclerViewHolder.getLayoutPosition());
                }
            });
        }
        if (this.mLongClickListener != null) {
            recyclerViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    BaseRecyclerAdapter.this.mLongClickListener.onItemLongClick(recyclerViewHolder.itemView, recyclerViewHolder.getLayoutPosition());
                    return true;
                }
            });
        }
        return recyclerViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i) {
        bindData(recyclerViewHolder, i, this.mData.get(i));
    }

    public T getItem(int i) {
        return this.mData.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    public List<T> getData() {
        return this.mData;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void add(int i, T t) {
        this.mData.add(i, t);
        notifyItemInserted(i);
    }

    public void prepend(List<T> list) {
        this.mData.addAll(0, list);
        notifyDataSetChanged();
    }

    public void append(List<T> list) {
        this.mData.addAll(list);
        notifyDataSetChanged();
    }

    public void delete(int i) {
        this.mData.remove(i);
        notifyItemRemoved(i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mLongClickListener = onItemLongClickListener;
    }
}
