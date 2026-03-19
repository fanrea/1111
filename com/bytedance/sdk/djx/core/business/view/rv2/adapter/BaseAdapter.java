package com.bytedance.sdk.djx.core.business.view.rv2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.view.rv2.base.CommonItemViewManager;
import com.bytedance.sdk.djx.core.business.view.rv2.base.CommonViewHolder;
import com.bytedance.sdk.djx.core.business.view.rv2.base.ItemView;
import com.bytedance.sdk.djx.core.business.view.rv2.base.ItemViewFactory;
import com.bytedance.sdk.djx.core.util.repeatclick.OnClickFastListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BaseAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private static final String TAG = "BaseAdapter";
    private DataChangedCallback mCallback;
    private final List<Object> mDatas;
    private final ItemViewFactory mItemViewFactory;
    private final CommonItemViewManager mItemViewManager;
    private OnItemClickListener mOnItemClickListener;

    public interface DataChangedCallback {
        void onItemRangePreInserted(int i, int i2);

        void onItemRangePreRemoved(int i, int i2);

        void onPreChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Object obj, CommonViewHolder commonViewHolder, int i);

        boolean onItemLongClick(View view, Object obj, CommonViewHolder commonViewHolder, int i);
    }

    protected void onItemClick(View view, Object obj, CommonViewHolder commonViewHolder, int i) {
    }

    protected boolean onItemLongClick(View view, Object obj, CommonViewHolder commonViewHolder, int i) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((CommonViewHolder) viewHolder, i, (List<Object>) list);
    }

    public BaseAdapter(ItemViewFactory itemViewFactory) {
        this(itemViewFactory, null);
    }

    public BaseAdapter(ItemViewFactory itemViewFactory, List<Object> list) {
        ArrayList arrayList = new ArrayList();
        this.mDatas = arrayList;
        this.mItemViewFactory = itemViewFactory;
        Entry validEntry = getValidEntry(list);
        arrayList.addAll(validEntry.datas);
        this.mItemViewManager = new CommonItemViewManager(validEntry.itemViews);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setDataChangedCallBack(DataChangedCallback dataChangedCallback) {
        this.mCallback = dataChangedCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CommonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        Iterator<? extends ItemView> it = this.mItemViewManager.getItemViews().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ItemView next = it.next();
            if (next.getLayoutRes() == i) {
                next.resizeView(viewInflate);
                break;
            }
        }
        return new CommonViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CommonViewHolder commonViewHolder, int i) {
        onBindViewHolder(commonViewHolder, i, Collections.emptyList());
    }

    public void onBindViewHolder(CommonViewHolder commonViewHolder, int i, List<Object> list) {
        ItemView itemView = this.mItemViewManager.get(i);
        if (itemView == null) {
            return;
        }
        setListener(commonViewHolder, itemView, i);
        commonViewHolder.bind(itemView, i, list);
    }

    protected void setListener(final CommonViewHolder commonViewHolder, final ItemView<?> itemView, int i) {
        if (commonViewHolder == null) {
            return;
        }
        commonViewHolder.itemView.setOnClickListener(new OnClickFastListener() { // from class: com.bytedance.sdk.djx.core.business.view.rv2.adapter.BaseAdapter.1
            @Override // com.bytedance.sdk.djx.core.util.repeatclick.OnClickFastListener
            public void onFastClick(View view) {
                int adapterPosition = commonViewHolder.getAdapterPosition();
                if (adapterPosition >= BaseAdapter.this.mDatas.size() || adapterPosition < 0) {
                    return;
                }
                Object obj = BaseAdapter.this.mDatas.get(adapterPosition);
                if (BaseAdapter.this.mOnItemClickListener != null) {
                    BaseAdapter.this.mOnItemClickListener.onItemClick(view, obj, commonViewHolder, adapterPosition);
                }
                BaseAdapter.this.onItemClick(view, obj, commonViewHolder, adapterPosition);
                itemView.onItemClick(commonViewHolder, adapterPosition);
            }
        });
        commonViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.rv2.adapter.BaseAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int adapterPosition = commonViewHolder.getAdapterPosition();
                if (adapterPosition >= BaseAdapter.this.mDatas.size() || adapterPosition < 0) {
                    return false;
                }
                Object obj = BaseAdapter.this.mDatas.get(adapterPosition);
                return ((BaseAdapter.this.mOnItemClickListener != null ? BaseAdapter.this.mOnItemClickListener.onItemLongClick(view, obj, commonViewHolder, adapterPosition) : false) || BaseAdapter.this.onItemLongClick(view, obj, commonViewHolder, adapterPosition)) || itemView.onItemLongClick(commonViewHolder, adapterPosition);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mItemViewManager.get(i).getLayoutRes();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDatas.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(CommonViewHolder commonViewHolder) {
        super.onViewRecycled((BaseAdapter) commonViewHolder);
        commonViewHolder.unbind();
    }

    public List<? extends ItemView> getItemViews() {
        return new ArrayList(this.mItemViewManager.getItemViews());
    }

    public List<Object> getDatas() {
        return this.mDatas;
    }

    public Object getItemData(int i) {
        if (i < 0 || i >= this.mDatas.size()) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public int indexOf(Object obj) {
        return this.mDatas.indexOf(obj);
    }

    public void add(Object obj) {
        add(this.mDatas.size(), obj);
    }

    public void add(int i, Object obj) {
        ItemView itemViewCreate;
        if (i < 0 || i > this.mDatas.size() || obj == null || (itemViewCreate = this.mItemViewFactory.create(obj)) == null) {
            return;
        }
        DataChangedCallback dataChangedCallback = this.mCallback;
        if (dataChangedCallback != null) {
            dataChangedCallback.onItemRangePreInserted(i, 1);
        }
        this.mDatas.add(obj);
        this.mItemViewManager.add(i, itemViewCreate);
        notifyItemInserted(i);
    }

    public int addAll(List<Object> list) {
        return addAll(this.mDatas.size(), list);
    }

    public int addAll(int i, List<Object> list) {
        if (i < 0 || i > this.mDatas.size()) {
            return -1;
        }
        if (list == null || list.isEmpty()) {
            return 0;
        }
        Entry validEntry = getValidEntry(list);
        DataChangedCallback dataChangedCallback = this.mCallback;
        if (dataChangedCallback != null) {
            dataChangedCallback.onItemRangePreInserted(i, validEntry.itemViews.size());
        }
        this.mDatas.addAll(i, validEntry.datas);
        this.mItemViewManager.addAll(i, validEntry.itemViews);
        notifyItemRangeInserted(i, validEntry.itemViews.size());
        return validEntry.datas.size();
    }

    public void remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0 || iIndexOf >= this.mDatas.size()) {
            return;
        }
        DataChangedCallback dataChangedCallback = this.mCallback;
        if (dataChangedCallback != null) {
            dataChangedCallback.onItemRangePreRemoved(iIndexOf, 1);
        }
        this.mDatas.remove(iIndexOf);
        this.mItemViewManager.remove(iIndexOf);
        notifyItemRemoved(iIndexOf);
    }

    public void removeAll() {
        int size = this.mDatas.size();
        DataChangedCallback dataChangedCallback = this.mCallback;
        if (dataChangedCallback != null) {
            dataChangedCallback.onItemRangePreRemoved(0, size);
        }
        this.mDatas.clear();
        this.mItemViewManager.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void replace(List<Object> list) {
        final Entry validEntry = getValidEntry(list);
        if (this.mDatas.isEmpty()) {
            addAll(validEntry.datas);
            return;
        }
        if (validEntry.datas.isEmpty()) {
            removeAll();
            return;
        }
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.bytedance.sdk.djx.core.business.view.rv2.adapter.BaseAdapter.3
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return BaseAdapter.this.mItemViewManager.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return validEntry.itemViews.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                ItemView itemView = BaseAdapter.this.mItemViewManager.get(i);
                ItemView itemView2 = validEntry.itemViews.get(i2);
                return (itemView == null || itemView2 == null || !itemView.isItemTheSame(itemView2)) ? false : true;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                ItemView itemView = BaseAdapter.this.mItemViewManager.get(i);
                ItemView itemView2 = validEntry.itemViews.get(i2);
                return (itemView == null || itemView2 == null || !itemView.isContentTheSame(itemView2)) ? false : true;
            }
        });
        this.mDatas.clear();
        this.mDatas.addAll(validEntry.datas);
        this.mItemViewManager.clear();
        this.mItemViewManager.addAll(validEntry.itemViews);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    private final Entry getValidEntry(List<Object> list) {
        if (list == null) {
            return new Entry(new ArrayList(), new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            ItemView itemViewCreate = this.mItemViewFactory.create(obj);
            if (itemViewCreate != null) {
                arrayList.add(obj);
                arrayList2.add(itemViewCreate);
            }
        }
        return new Entry(arrayList, arrayList2);
    }

    private static class Entry {
        List<Object> datas;
        List<? extends ItemView> itemViews;

        public Entry(List<Object> list, List<? extends ItemView> list2) {
            this.datas = list;
            this.itemViews = list2;
        }
    }
}
