package com.style.widget.viewpager2;

import android.view.ViewGroup;
import com.baidu.mobads.container.adrequest.i;
import com.component.interfaces.RemoteDelegator;
import com.style.widget.viewpager2.RVViewHolder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class RVAdapter<VH extends RVViewHolder> extends RemoteDelegator<Object> {
    private static final String METHOD_NOTIFY_DATASET_CHANGED = "notifyDataSetChanged";
    private static final String METHOD_NOTIFY_ITEM_CHANGED = "notifyItemChanged";
    private static final String METHOD_NOTIFY_RANGE_CHANGED = "notifyItemRangeChanged";
    private static final String METHOD_NOTIFY_RANGE_INSERTED = "notifyRangeInserted";
    private static final String METHOD_NOTIFY_RANGE_REMOVED = "notifyRangeRemoved";

    public abstract int getItemCount();

    public abstract void onBindViewHolder(VH vh, int i);

    public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

    public RVAdapter(i iVar) {
        super("RVAdapter", iVar, new Object[0]);
        addEvent(METHOD_NOTIFY_ITEM_CHANGED, Object.class);
        addEvent(METHOD_NOTIFY_RANGE_INSERTED, Integer.class, Integer.class);
        addEvent(METHOD_NOTIFY_RANGE_REMOVED, Integer.class, Integer.class);
        addEvent(METHOD_NOTIFY_RANGE_CHANGED, Integer.class, Integer.class);
        addEvent(METHOD_NOTIFY_DATASET_CHANGED, new Class[0]);
        setCallback(new RemoteDelegator.Callback() { // from class: com.style.widget.viewpager2.RVAdapter.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.component.interfaces.RemoteDelegator.Callback
            public Object onResult(String str, Object[] objArr) {
                if ("onCreateViewHolder".equals(str) && RemoteDelegator.validateArgs(objArr, ViewGroup.class, Integer.class)) {
                    return RVAdapter.this.onCreateViewHolder((ViewGroup) objArr[0], ((Integer) objArr[1]).intValue()).getInstance();
                }
                if ("onBindViewHolder".equals(str) && RemoteDelegator.validateArgs(objArr, RVViewHolder.class, Integer.class)) {
                    RVAdapter.this.onBindViewHolder((RVViewHolder) objArr[0], ((Integer) objArr[1]).intValue());
                    return null;
                }
                if ("getItemId".equals(str) && RemoteDelegator.validateArgs(objArr, Integer.class)) {
                    return Long.valueOf(RVAdapter.this.getItemId(((Integer) objArr[0]).intValue()));
                }
                if ("getItemType".equals(str) && RemoteDelegator.validateArgs(objArr, Integer.class)) {
                    return Integer.valueOf(RVAdapter.this.getItemType(((Integer) objArr[0]).intValue()));
                }
                if ("getItemCount".equals(str)) {
                    return Integer.valueOf(RVAdapter.this.getItemCount());
                }
                if ("onViewRecycled".equals(str) && RemoteDelegator.validateArgs(objArr, RVViewHolder.class)) {
                    RVAdapter.this.onViewRecycled((RVViewHolder) objArr[0]);
                    return null;
                }
                if ("onFailedToRecycleView".equals(str) && RemoteDelegator.validateArgs(objArr, RVViewHolder.class)) {
                    return Boolean.valueOf(RVAdapter.this.onFailedToRecycleView((RVViewHolder) objArr[0]));
                }
                if ("onViewAttachedToWindow".equals(str) && RemoteDelegator.validateArgs(objArr, RVViewHolder.class)) {
                    RVAdapter.this.onViewAttachedToWindow((RVViewHolder) objArr[0]);
                    return null;
                }
                if ("onViewDetachedFromWindow".equals(str) && RemoteDelegator.validateArgs(objArr, RVViewHolder.class)) {
                    RVAdapter.this.onViewDetachedFromWindow((RVViewHolder) objArr[0]);
                    return null;
                }
                if ("onAttachedToRecyclerView".equals(str) && RemoteDelegator.validateArgs(objArr, ViewGroup.class)) {
                    RVAdapter.this.onAttachedToRecyclerView((ViewGroup) objArr[0]);
                    return null;
                }
                if ("onDetachedFromRecyclerView".equals(str) && RemoteDelegator.validateArgs(objArr, ViewGroup.class)) {
                    RVAdapter.this.onDetachedFromRecyclerView((ViewGroup) objArr[0]);
                    return null;
                }
                if ("onChanged".equals(str)) {
                    RVAdapter.this.onDataSetChanged();
                    return null;
                }
                return null;
            }
        });
    }

    @Override // com.component.interfaces.RemoteDelegator
    protected Object transformInstance(Object obj) {
        return obj;
    }

    public final void notifyItemChanged(int i) {
        dispatch(METHOD_NOTIFY_ITEM_CHANGED, Integer.valueOf(i), null);
    }

    public final void notifyItemChanged(int i, Object obj) {
        dispatch(METHOD_NOTIFY_ITEM_CHANGED, Integer.valueOf(i), obj);
    }

    public void notifyItemRangeInserted(int i, int i2) {
        dispatch(METHOD_NOTIFY_RANGE_INSERTED, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void notifyItemRangeRemoved(int i, int i2) {
        dispatch(METHOD_NOTIFY_RANGE_REMOVED, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void notifyItemRangeChanged(int i, int i2) {
        dispatch(METHOD_NOTIFY_RANGE_CHANGED, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void notifyDataSetChanged() {
        dispatch(METHOD_NOTIFY_DATASET_CHANGED, new Object[0]);
    }

    protected void onDataSetChanged() {
    }

    public long getItemId(int i) {
        return -1L;
    }

    public int getItemType(int i) {
        return 0;
    }

    public void onViewRecycled(VH vh) {
    }

    public boolean onFailedToRecycleView(RVViewHolder rVViewHolder) {
        return false;
    }

    public void onViewAttachedToWindow(RVViewHolder rVViewHolder) {
    }

    public void onViewDetachedFromWindow(RVViewHolder rVViewHolder) {
    }

    public void onAttachedToRecyclerView(ViewGroup viewGroup) {
    }

    public void onDetachedFromRecyclerView(ViewGroup viewGroup) {
    }
}
