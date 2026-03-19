package com.bytedance.sdk.djx.core.business.view.rv.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.view.rv.base.BaseViewHolder;
import com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView;
import com.bytedance.sdk.djx.core.business.view.rv.base.ItemViewManager;
import com.bytedance.sdk.djx.core.util.repeatclick.OnClickFastListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class MultiItemTypeAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private DataChangedCallback mCallback;
    protected Context mContext;
    private final List<Object> mDataList;
    private final ItemViewManager mItemViewManager;
    private OnItemClickListener mOnItemClickListener;

    public interface DataChangedCallback {
        void onItemRangePreInserted(int i, int i2);

        void onItemRangePreRemoved(int i, int i2);

        void onPreChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Object obj, BaseViewHolder baseViewHolder, int i);

        boolean onItemLongClick(View view, Object obj, BaseViewHolder baseViewHolder, int i);
    }

    protected abstract List<IMultiItemView> buildMultiItemViews();

    protected boolean isEnabled(int i) {
        return true;
    }

    protected void onItemClick(View view, Object obj, BaseViewHolder baseViewHolder, int i) {
    }

    protected boolean onItemLongClick(View view, Object obj, BaseViewHolder baseViewHolder, int i) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((BaseViewHolder) viewHolder, i, (List<Object>) list);
    }

    public MultiItemTypeAdapter() {
        this.mDataList = new ArrayList();
        this.mItemViewManager = new ItemViewManager();
    }

    public MultiItemTypeAdapter(Context context) {
        this.mDataList = new ArrayList();
        this.mContext = context;
        ItemViewManager itemViewManager = new ItemViewManager();
        this.mItemViewManager = itemViewManager;
        itemViewManager.addItemViews(buildMultiItemViews());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mItemViewManager.getItemViewType(this.mDataList.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        BaseViewHolder baseViewHolderCreateViewHolder;
        if (i == -1) {
            i = 1;
        }
        Object itemViewLayoutId = this.mItemViewManager.getItemView(i).getItemViewLayoutId();
        if (itemViewLayoutId instanceof View) {
            baseViewHolderCreateViewHolder = BaseViewHolder.createViewHolder(this.mContext, (View) itemViewLayoutId);
        } else {
            baseViewHolderCreateViewHolder = BaseViewHolder.createViewHolder(this.mContext, viewGroup, ((Integer) itemViewLayoutId).intValue());
        }
        setListener(viewGroup, baseViewHolderCreateViewHolder, i);
        return baseViewHolderCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        bindViewHolder(baseViewHolder, this.mDataList.get(i));
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i, List<Object> list) {
        bindViewHolder(baseViewHolder, this.mDataList.get(i), list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDataList.size();
    }

    public List<Object> getDataList() {
        return this.mDataList;
    }

    public Object getItemData(int i) {
        if (i < 0 || i >= this.mDataList.size()) {
            return null;
        }
        return this.mDataList.get(i);
    }

    public void setDataChangedCallBack(DataChangedCallback dataChangedCallback) {
        this.mCallback = dataChangedCallback;
    }

    public void addItemViews(List<IMultiItemView> list) {
        this.mItemViewManager.addItemViews(list);
    }

    private void bindViewHolder(BaseViewHolder baseViewHolder, Object obj) {
        this.mItemViewManager.bindViewHolder(baseViewHolder, obj, baseViewHolder.getAdapterPosition());
    }

    private void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, List<Object> list) {
        this.mItemViewManager.bindViewHolder(baseViewHolder, obj, baseViewHolder.getAdapterPosition(), list);
    }

    public void addAll(List<?> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        DataChangedCallback dataChangedCallback = this.mCallback;
        if (dataChangedCallback != null) {
            dataChangedCallback.onItemRangePreInserted(this.mDataList.size(), list.size());
        }
        this.mDataList.addAll(list);
        notifyItemRangeChanged(this.mDataList.size() - list.size(), this.mDataList.size());
    }

    public void addAll(int i, List<Object> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        DataChangedCallback dataChangedCallback = this.mCallback;
        if (dataChangedCallback != null) {
            dataChangedCallback.onPreChanged();
        }
        this.mDataList.addAll(i, list);
        notifyItemRangeChanged(i, list.size() + i);
    }

    public void insert(int i, Object obj) {
        DataChangedCallback dataChangedCallback = this.mCallback;
        if (dataChangedCallback != null) {
            dataChangedCallback.onItemRangePreInserted(i, 1);
        }
        this.mDataList.add(i, obj);
        notifyItemInserted(i);
    }

    public void remove(int i) {
        DataChangedCallback dataChangedCallback = this.mCallback;
        if (dataChangedCallback != null) {
            dataChangedCallback.onItemRangePreRemoved(i, 1);
        }
        this.mDataList.remove(i);
        notifyItemRemoved(i);
        if (i != this.mDataList.size()) {
            notifyItemRangeChanged(i, this.mDataList.size() - i);
        }
    }

    public void clear() {
        DataChangedCallback dataChangedCallback = this.mCallback;
        if (dataChangedCallback != null) {
            dataChangedCallback.onPreChanged();
        }
        this.mDataList.clear();
        notifyDataSetChanged();
    }

    protected void setListener(ViewGroup viewGroup, final BaseViewHolder baseViewHolder, int i) {
        if (!isEnabled(i) || baseViewHolder == null) {
            return;
        }
        final IMultiItemView itemView = this.mItemViewManager.getItemView(i);
        baseViewHolder.getConvertView().setOnClickListener(new OnClickFastListener() { // from class: com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter.1
            @Override // com.bytedance.sdk.djx.core.util.repeatclick.OnClickFastListener
            public void onFastClick(View view) {
                int adapterPosition = baseViewHolder.getAdapterPosition();
                if (adapterPosition >= MultiItemTypeAdapter.this.mDataList.size() || adapterPosition < 0) {
                    return;
                }
                Object obj = MultiItemTypeAdapter.this.mDataList.get(adapterPosition);
                if (MultiItemTypeAdapter.this.mOnItemClickListener != null) {
                    MultiItemTypeAdapter.this.mOnItemClickListener.onItemClick(view, obj, baseViewHolder, adapterPosition);
                }
                MultiItemTypeAdapter.this.onItemClick(view, obj, baseViewHolder, adapterPosition);
                itemView.onItemClick(baseViewHolder, obj, adapterPosition);
                baseViewHolder.onItemClick(adapterPosition, obj);
            }
        });
        baseViewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int adapterPosition = baseViewHolder.getAdapterPosition();
                if (adapterPosition >= MultiItemTypeAdapter.this.mDataList.size() || adapterPosition < 0) {
                    return false;
                }
                Object obj = MultiItemTypeAdapter.this.mDataList.get(adapterPosition);
                return (((MultiItemTypeAdapter.this.mOnItemClickListener != null ? MultiItemTypeAdapter.this.mOnItemClickListener.onItemLongClick(view, obj, baseViewHolder, adapterPosition) : false) || MultiItemTypeAdapter.this.onItemLongClick(view, obj, baseViewHolder, adapterPosition)) || itemView.onItemLongClick(baseViewHolder, obj, adapterPosition)) || baseViewHolder.onItemLongClick(adapterPosition, obj);
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
