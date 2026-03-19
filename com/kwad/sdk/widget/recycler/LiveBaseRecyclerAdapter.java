package com.kwad.sdk.widget.recycler;

import android.support.v7.widget.aj;
import android.support.v7.widget.aj.x;
import com.kwad.sdk.utils.LiveAutoIndexTemplateList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class LiveBaseRecyclerAdapter<M, VH extends aj.x> extends aj.a<VH> {
    public final boolean mDispatchModify;
    protected List<M> mModelList;

    public LiveBaseRecyclerAdapter() {
        this(true);
    }

    public LiveBaseRecyclerAdapter(boolean z) {
        this.mDispatchModify = z;
        this.mModelList = new LiveAutoIndexTemplateList(new CopyOnWriteArrayList());
    }

    public void setList(List<M> list) {
        this.mModelList.clear();
        this.mModelList.addAll(list);
    }

    public List<M> getList() {
        return this.mModelList;
    }

    @Override // android.support.v7.widget.aj.a
    public int getItemCount() {
        return this.mModelList.size();
    }

    public boolean isEmpty() {
        return this.mModelList.isEmpty();
    }

    public M getItem(int i) {
        if (i < 0 || i >= this.mModelList.size()) {
            return null;
        }
        return this.mModelList.get(i);
    }

    public int getItemPosition(M m) {
        return this.mModelList.indexOf(m);
    }

    public LiveBaseRecyclerAdapter<M, VH> add(M m) {
        this.mModelList.add(m);
        if (this.mDispatchModify && this.mModelList.size() > 0) {
            notifyItemInserted(this.mModelList.size() - 1);
        }
        return this;
    }

    public LiveBaseRecyclerAdapter<M, VH> add(int i, M m) {
        this.mModelList.add(i, m);
        if (!this.mDispatchModify) {
            return this;
        }
        notifyItemInserted(i);
        return this;
    }

    public LiveBaseRecyclerAdapter<M, VH> remove(int i) {
        this.mModelList.remove(i);
        if (!this.mDispatchModify) {
            return this;
        }
        notifyItemRemoved(i);
        return this;
    }

    public LiveBaseRecyclerAdapter<M, VH> remove(M m) {
        int iIndexOf = this.mModelList.indexOf(m);
        this.mModelList.remove(m);
        if (this.mDispatchModify && iIndexOf != -1) {
            notifyItemRemoved(iIndexOf);
        }
        return this;
    }

    public LiveBaseRecyclerAdapter<M, VH> removeList(int i, int i2) {
        this.mModelList.subList(i, i + i2).clear();
        if (!this.mDispatchModify) {
            return this;
        }
        notifyItemRangeRemoved(i, i2);
        return this;
    }

    public LiveBaseRecyclerAdapter<M, VH> set(int i, M m) {
        this.mModelList.set(i, m);
        if (!this.mDispatchModify) {
            return this;
        }
        notifyItemChanged(i);
        return this;
    }

    public LiveBaseRecyclerAdapter<M, VH> addAll(Collection<M> collection) {
        this.mModelList.addAll(collection);
        if (!this.mDispatchModify) {
            return this;
        }
        notifyItemRangeInserted(this.mModelList.size(), collection.size());
        return this;
    }

    public LiveBaseRecyclerAdapter<M, VH> removeAll(M m) {
        Iterator<M> it = this.mModelList.iterator();
        while (it.hasNext()) {
            if (m.equals(it.next())) {
                it.remove();
            }
        }
        if (!this.mDispatchModify) {
            return this;
        }
        notifyDataSetChanged();
        return this;
    }

    public LiveBaseRecyclerAdapter<M, VH> clear() {
        int size = this.mModelList.size();
        this.mModelList.clear();
        if (!this.mDispatchModify) {
            return this;
        }
        notifyItemRangeRemoved(0, size);
        return this;
    }
}
