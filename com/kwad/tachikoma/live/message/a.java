package com.kwad.tachikoma.live.message;

import android.support.v7.widget.al;
import android.support.v7.widget.al.x;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class a<M, VH extends al.x> extends al.a<VH> {
    protected List<M> CV;
    public final boolean CW;

    public a() {
        this(true);
    }

    private a(boolean z) {
        this.CW = true;
        this.CV = new com.kwad.tachikoma.t.d(new CopyOnWriteArrayList());
    }

    @Override // android.support.v7.widget.al.a
    public final int getItemCount() {
        return this.CV.size();
    }

    public final a<M, VH> a(Collection<M> collection) {
        this.CV.addAll(collection);
        if (!this.CW) {
            return this;
        }
        ab(this.CV.size(), collection.size());
        return this;
    }
}
