package com.kwad.sdk.lib.widget.a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d extends RecyclerView.Adapter {
    private final a ccX;
    private final a ccY;
    private RecyclerView.Adapter ccZ;
    private final RecyclerView.AdapterDataObserver cda;
    private RecyclerView.AdapterDataObserver cdb;
    private RecyclerView.AdapterDataObserver cdc;
    private RecyclerView.Adapter cdd;
    private RecyclerView.Adapter cde;
    private int cdf;
    private int cdg;
    private boolean cdh;
    private int cdi;
    private boolean cdj;
    private boolean cdk;
    private Set<WeakReference<Object>> cdl;
    private boolean cdm;

    private static int gF(int i) {
        return i + 2048;
    }

    private static int gG(int i) {
        return i + 1024;
    }

    public d(RecyclerView.Adapter adapter) {
        this(adapter, null, null);
    }

    private d(RecyclerView.Adapter adapter, List<View> list, List<View> list2) {
        this.cdf = -2048;
        this.cdg = -1024;
        this.cdi = -1;
        this.cdj = false;
        this.cdk = true;
        this.cdl = new HashSet();
        this.ccZ = adapter;
        this.ccX = new a(null);
        this.ccY = new a(null);
        RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.kwad.sdk.lib.widget.a.d.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onChanged() {
                d.this.akY();
                if (!d.this.cdj) {
                    if (d.this.cdm) {
                        gH(d.this.ccZ.getItemCount());
                        return;
                    }
                    int itemCount = d.this.ccZ.getItemCount();
                    try {
                        if (d.this.cdi == -1 || (itemCount != 0 && itemCount == d.this.cdi)) {
                            d dVar = d.this;
                            dVar.notifyItemRangeChanged(dVar.akW(), itemCount);
                        } else {
                            d.this.notifyDataSetChanged();
                        }
                    } catch (Exception unused) {
                    }
                    d.this.cdi = itemCount;
                    return;
                }
                d.this.notifyDataSetChanged();
            }

            private void gH(int i) {
                try {
                    int i2 = d.this.cdi;
                    int iAkW = d.this.akW();
                    if (i2 == -1) {
                        d.this.notifyDataSetChanged();
                    } else if (i == i2) {
                        d.this.notifyItemRangeChanged(iAkW, i);
                    } else if (i > i2) {
                        d.this.notifyItemRangeChanged(iAkW, i2);
                        d.this.notifyItemRangeInserted(iAkW + i2, i - i2);
                    } else {
                        d.this.notifyItemRangeChanged(iAkW, i);
                        d.this.notifyItemRangeRemoved(iAkW + i, i2 - i);
                    }
                } catch (Exception unused) {
                }
                d.this.cdi = i;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeChanged(int i, int i2) {
                d dVar = d.this;
                dVar.cdi = dVar.ccZ.getItemCount();
                try {
                    d dVar2 = d.this;
                    dVar2.notifyItemRangeChanged(i + dVar2.akW(), i2);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeChanged(int i, int i2, Object obj) {
                d dVar = d.this;
                dVar.cdi = dVar.ccZ.getItemCount();
                try {
                    d dVar2 = d.this;
                    dVar2.notifyItemRangeChanged(i + dVar2.akW(), i2, obj);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeInserted(int i, int i2) {
                d dVar = d.this;
                dVar.cdi = dVar.ccZ.getItemCount();
                try {
                    d dVar2 = d.this;
                    dVar2.notifyItemRangeInserted(i + dVar2.akW(), i2);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeRemoved(int i, int i2) {
                try {
                    d dVar = d.this;
                    dVar.notifyItemRangeRemoved(i + dVar.akW(), i2);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeMoved(int i, int i2, int i3) {
                try {
                    d dVar = d.this;
                    dVar.notifyItemMoved(i + dVar.akW(), i2 + d.this.akW());
                } catch (Exception unused) {
                }
            }
        };
        this.cda = adapterDataObserver;
        this.cdb = adapterDataObserver;
        this.cdc = adapterDataObserver;
        this.ccZ.registerAdapterDataObserver(adapterDataObserver);
    }

    public final a akV() {
        return this.ccX;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (gD(i)) {
            int iGG = gG(i);
            RecyclerView.Adapter adapter = this.cdd;
            if (adapter == null) {
                return af(this.ccX.gI(iGG));
            }
            return adapter.onCreateViewHolder(viewGroup, iGG);
        }
        if (gE(i)) {
            int iGF = gF(i);
            RecyclerView.Adapter adapter2 = this.cde;
            if (adapter2 == null) {
                return af(this.ccY.gI(iGF));
            }
            return adapter2.onCreateViewHolder(viewGroup, iGF);
        }
        return this.ccZ.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.Adapter adapter;
        RecyclerView.Adapter adapter2;
        if (i < akW() || i >= akW() + this.ccZ.getItemCount()) {
            if (i < akW() && (adapter2 = this.cdd) != null) {
                adapter2.onBindViewHolder(viewHolder, i);
                return;
            } else {
                if (i < akW() + this.ccZ.getItemCount() || (adapter = this.cde) == null) {
                    return;
                }
                adapter.onBindViewHolder(viewHolder, (i - akW()) - this.ccZ.getItemCount());
                return;
            }
        }
        this.ccZ.onBindViewHolder(viewHolder, i - akW());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        RecyclerView.Adapter adapter;
        RecyclerView.Adapter adapter2;
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i);
            return;
        }
        if (i < akW() || i >= akW() + this.ccZ.getItemCount()) {
            if (i < akW() && (adapter2 = this.cdd) != null) {
                adapter2.onBindViewHolder(viewHolder, i, list);
                return;
            } else {
                if (i < akW() + this.ccZ.getItemCount() || (adapter = this.cde) == null) {
                    return;
                }
                adapter.onBindViewHolder(viewHolder, (i - akW()) - this.ccZ.getItemCount(), list);
                return;
            }
        }
        this.ccZ.onBindViewHolder(viewHolder, i - akW(), list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        if (gB(i)) {
            RecyclerView.Adapter adapter = this.cdd;
            if (adapter != null) {
                return adapter.getItemId(i);
            }
            return getItemViewType(i);
        }
        if (gC(i)) {
            RecyclerView.Adapter adapter2 = this.cde;
            if (adapter2 != null) {
                return adapter2.getItemId(i);
            }
            return getItemViewType(i);
        }
        return this.ccZ.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        int iGJ;
        int iGJ2;
        if (gB(i)) {
            RecyclerView.Adapter adapter = this.cdd;
            if (adapter != null) {
                iGJ2 = adapter.getItemViewType(i);
            } else {
                iGJ2 = this.ccX.gJ(i);
            }
            int i2 = iGJ2 - 1024;
            this.cdg = Math.max(i2, this.cdg);
            return i2;
        }
        if (gC(i)) {
            int itemCount = (i - this.ccZ.getItemCount()) - akW();
            RecyclerView.Adapter adapter2 = this.cde;
            if (adapter2 != null) {
                iGJ = adapter2.getItemViewType(itemCount);
            } else {
                iGJ = this.ccY.gJ(itemCount);
            }
            int i3 = iGJ - 2048;
            this.cdf = Math.max(i3, this.cdf);
            return i3;
        }
        return this.ccZ.getItemViewType(i - akW());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return akX() + akW() + this.ccZ.getItemCount();
    }

    public final int akW() {
        RecyclerView.Adapter adapter = this.cdd;
        return adapter != null ? adapter.getItemCount() : this.ccX.ala();
    }

    public final int akX() {
        RecyclerView.Adapter adapter = this.cde;
        return adapter != null ? adapter.getItemCount() : this.ccY.ala();
    }

    public final boolean gB(int i) {
        return i < akW();
    }

    public final boolean gC(int i) {
        return i >= akW() + this.ccZ.getItemCount();
    }

    public final boolean removeFooterView(View view) {
        boolean zAi = this.ccY.ai(view);
        if (zAi) {
            akZ();
        }
        return zAi;
    }

    public final void addHeaderView(View view) {
        a(view, (ViewGroup.LayoutParams) null);
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null");
        }
        if (this.ccX.ah(view)) {
            akZ();
        }
        akY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        Iterator<WeakReference<Object>> it = this.cdl.iterator();
        while (it.hasNext()) {
            it.next().get();
        }
    }

    public final void addFooterView(View view) {
        b(view, null);
    }

    private void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null!");
        }
        if ((view.getParent() instanceof ViewGroup) && view.getParent() != this.ccY) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (this.ccY.ah(view)) {
            akZ();
        }
    }

    public final boolean ad(View view) {
        return this.ccY.ag(view);
    }

    public final boolean ae(View view) {
        return this.ccX.ag(view);
    }

    private void akZ() {
        try {
            notifyDataSetChanged();
        } catch (Exception unused) {
        }
    }

    private boolean gD(int i) {
        return i >= -1024 && i <= this.cdg;
    }

    private boolean gE(int i) {
        return i >= -2048 && i <= this.cdf;
    }

    private RecyclerView.ViewHolder af(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = layoutParams == null ? -1 : layoutParams.width;
        int i2 = layoutParams == null ? -2 : layoutParams.height;
        if (this.cdk) {
            if (this.cdh) {
                StaggeredGridLayoutManager.LayoutParams layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(i, i2);
                layoutParams2.setFullSpan(true);
                view.setLayoutParams(layoutParams2);
            } else {
                view.setLayoutParams(new RecyclerView.LayoutParams(i, i2));
            }
        }
        return new RecyclerView.ViewHolder(view) { // from class: com.kwad.sdk.lib.widget.a.d.2
        };
    }

    public final void d(RecyclerView recyclerView) {
        a(recyclerView, (GridLayoutManager.SpanSizeLookup) null);
    }

    private void a(RecyclerView recyclerView, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            final GridLayoutManager.SpanSizeLookup spanSizeLookup2 = null;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.kwad.sdk.lib.widget.a.d.3
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public final int getSpanSize(int i) {
                    if (d.this.gB(i) || d.this.gC(i)) {
                        return gridLayoutManager.getSpanCount();
                    }
                    GridLayoutManager.SpanSizeLookup spanSizeLookup3 = spanSizeLookup2;
                    if (spanSizeLookup3 != null) {
                        return spanSizeLookup3.getSpanSize(i);
                    }
                    return 1;
                }
            });
        }
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            this.cdh = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        int itemViewType = viewHolder.getItemViewType();
        if (gD(itemViewType)) {
            RecyclerView.Adapter adapter = this.cdd;
            if (adapter != null) {
                adapter.onViewAttachedToWindow(viewHolder);
                return;
            }
            return;
        }
        if (gE(itemViewType)) {
            RecyclerView.Adapter adapter2 = this.cde;
            if (adapter2 != null) {
                adapter2.onViewAttachedToWindow(viewHolder);
                return;
            }
            return;
        }
        this.ccZ.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        int itemViewType = viewHolder.getItemViewType();
        if (gD(itemViewType)) {
            RecyclerView.Adapter adapter = this.cdd;
            if (adapter != null) {
                adapter.onViewDetachedFromWindow(viewHolder);
                return;
            }
            return;
        }
        if (gE(itemViewType)) {
            RecyclerView.Adapter adapter2 = this.cde;
            if (adapter2 != null) {
                adapter2.onViewDetachedFromWindow(viewHolder);
                return;
            }
            return;
        }
        this.ccZ.onViewDetachedFromWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.ccZ.hasObservers()) {
            this.ccZ.unregisterAdapterDataObserver(this.cda);
        }
        this.ccZ.registerAdapterDataObserver(this.cda);
        this.ccZ.onAttachedToRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.cdd;
        if (adapter != null) {
            adapter.onAttachedToRecyclerView(recyclerView);
            this.cdd.unregisterAdapterDataObserver(this.cdb);
            this.cdd.registerAdapterDataObserver(this.cdb);
        }
        RecyclerView.Adapter adapter2 = this.cde;
        if (adapter2 != null) {
            adapter2.onAttachedToRecyclerView(recyclerView);
            this.cde.unregisterAdapterDataObserver(this.cdc);
            this.cde.registerAdapterDataObserver(this.cdc);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.ccZ.hasObservers()) {
            this.ccZ.unregisterAdapterDataObserver(this.cda);
        }
        this.ccZ.onDetachedFromRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.cdd;
        if (adapter != null) {
            adapter.onDetachedFromRecyclerView(recyclerView);
            this.cdd.unregisterAdapterDataObserver(this.cdb);
        }
        RecyclerView.Adapter adapter2 = this.cde;
        if (adapter2 != null) {
            adapter2.onDetachedFromRecyclerView(recyclerView);
            this.cde.unregisterAdapterDataObserver(this.cdc);
        }
    }

    public final RecyclerView.Adapter getAdapter() {
        return this.ccZ;
    }

    public static class a {
        public final SparseArray<View> cdr;
        public int mIndex;

        a() {
            this(null);
        }

        a(List<View> list) {
            this.cdr = new SparseArray<>();
            this.mIndex = 0;
            if (list != null) {
                for (View view : list) {
                    SparseArray<View> sparseArray = this.cdr;
                    int i = this.mIndex;
                    this.mIndex = i + 1;
                    sparseArray.put(i, view);
                }
            }
        }

        final boolean ag(View view) {
            return this.cdr.indexOfValue(view) >= 0;
        }

        final boolean ah(View view) {
            if (ag(view)) {
                return false;
            }
            SparseArray<View> sparseArray = this.cdr;
            int i = this.mIndex;
            this.mIndex = i + 1;
            sparseArray.put(i, view);
            return true;
        }

        final boolean ai(View view) {
            int iIndexOfValue = this.cdr.indexOfValue(view);
            if (iIndexOfValue < 0) {
                return false;
            }
            this.cdr.removeAt(iIndexOfValue);
            return true;
        }

        final View gI(int i) {
            return this.cdr.get(i);
        }

        final int gJ(int i) {
            if (i < 0 || i >= this.cdr.size()) {
                return -1;
            }
            return this.cdr.keyAt(i);
        }

        final int ala() {
            return this.cdr.size();
        }
    }
}
