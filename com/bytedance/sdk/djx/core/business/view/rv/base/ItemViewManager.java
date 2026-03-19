package com.bytedance.sdk.djx.core.business.view.rv.base;

import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ItemViewManager {
    private SparseArray<IMultiItemView> mItemViews = new SparseArray<>();

    public ItemViewManager addItemView(IMultiItemView iMultiItemView) {
        int size = this.mItemViews.size();
        if (iMultiItemView != null) {
            this.mItemViews.put(size, iMultiItemView);
        }
        return this;
    }

    public ItemViewManager addItemView(int i, IMultiItemView iMultiItemView) {
        if (this.mItemViews.get(i) != null) {
            return null;
        }
        this.mItemViews.put(i, iMultiItemView);
        return this;
    }

    public ItemViewManager addItemViews(List<IMultiItemView> list) {
        if (list != null) {
            Iterator<IMultiItemView> it = list.iterator();
            int i = 1;
            while (it.hasNext()) {
                addItemView(i, it.next());
                i++;
            }
        }
        return this;
    }

    public ItemViewManager removeItemView(IMultiItemView iMultiItemView) {
        if (iMultiItemView == null) {
            return null;
        }
        int iIndexOfValue = this.mItemViews.indexOfValue(iMultiItemView);
        if (iIndexOfValue >= 0) {
            this.mItemViews.removeAt(iIndexOfValue);
        }
        return this;
    }

    public ItemViewManager removeItemView(int i) {
        int iIndexOfKey = this.mItemViews.indexOfKey(i);
        if (iIndexOfKey >= 0) {
            this.mItemViews.removeAt(iIndexOfKey);
        }
        return this;
    }

    public int getItemViewType(Object obj, int i) {
        for (int size = this.mItemViews.size() - 1; size >= 0; size--) {
            if (this.mItemViews.valueAt(size).isForViewType(obj, i)) {
                return this.mItemViews.keyAt(size);
            }
        }
        return -1;
    }

    public void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, int i) {
        int size = this.mItemViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            IMultiItemView iMultiItemViewValueAt = this.mItemViews.valueAt(i2);
            if (iMultiItemViewValueAt.isForViewType(obj, i)) {
                iMultiItemViewValueAt.bindViewHolder(baseViewHolder, obj, i);
                return;
            }
        }
    }

    public void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, int i, List<Object> list) {
        int size = this.mItemViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            IMultiItemView iMultiItemViewValueAt = this.mItemViews.valueAt(i2);
            if (iMultiItemViewValueAt.isForViewType(obj, i)) {
                iMultiItemViewValueAt.bindViewHolder(baseViewHolder, obj, i, list);
                return;
            }
        }
    }

    public void add(BaseViewHolder baseViewHolder, Object obj, int i) {
        int size = this.mItemViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            IMultiItemView iMultiItemViewValueAt = this.mItemViews.valueAt(i2);
            if (iMultiItemViewValueAt.isForViewType(obj, i)) {
                iMultiItemViewValueAt.bindViewHolder(baseViewHolder, obj, i);
                return;
            }
        }
    }

    public IMultiItemView getItemView(int i) {
        return this.mItemViews.get(i);
    }
}
