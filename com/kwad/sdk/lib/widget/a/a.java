package com.kwad.sdk.lib.widget.a;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<M> ccN;
    public final boolean ccO;

    public a() {
        this(true);
    }

    public a(boolean z) {
        this.ccO = z;
        this.ccN = new com.kwad.sdk.lib.widget.b(new CopyOnWriteArrayList());
    }

    public final void aC(List<M> list) {
        this.ccN.clear();
        this.ccN.addAll(list);
    }

    public final List<M> akS() {
        return this.ccN;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.ccN.size();
    }

    public final boolean isEmpty() {
        return this.ccN.isEmpty();
    }

    public M getItem(int i) {
        if (i < 0 || i >= this.ccN.size()) {
            return null;
        }
        return this.ccN.get(i);
    }
}
