package com.bytedance.sdk.djx.core.business.view.rv2.base;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CommonItemViewManager {
    private final List<ItemView> mItemViews;

    public CommonItemViewManager(List<? extends ItemView> list) {
        if (list == null) {
            this.mItemViews = new ArrayList();
        } else {
            this.mItemViews = new ArrayList(list);
        }
    }

    public ItemView get(int i) {
        return this.mItemViews.get(i);
    }

    public int size() {
        return this.mItemViews.size();
    }

    public List<? extends ItemView> getItemViews() {
        return this.mItemViews;
    }

    public boolean contains(ItemView itemView) {
        return this.mItemViews.contains(itemView);
    }

    public int indexOf(ItemView itemView) {
        return this.mItemViews.indexOf(itemView);
    }

    public void add(int i, ItemView itemView) {
        this.mItemViews.add(i, itemView);
    }

    public void addAll(List<? extends ItemView> list) {
        this.mItemViews.addAll(list);
    }

    public void addAll(int i, List<? extends ItemView> list) {
        this.mItemViews.addAll(i, list);
    }

    public void remove(int i) {
        this.mItemViews.remove(i);
    }

    public void remove(int i, int i2) {
        this.mItemViews.subList(i, i2).clear();
    }

    public void clear() {
        this.mItemViews.clear();
    }

    public boolean isEmpty() {
        return this.mItemViews.isEmpty();
    }
}
