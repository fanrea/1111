package com.kwad.sdk.lib.widget.a.a;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d<T> {
    private List<T> SW;
    private final RecyclerView.Adapter ccZ;
    private final b<T> cdA;
    public volatile boolean cdB;
    private List<T> cdC = Collections.emptyList();
    private int cdD;
    private final ListUpdateCallback cdz;

    public d(ListUpdateCallback listUpdateCallback, b<T> bVar, RecyclerView.Adapter adapter) {
        this.cdz = listUpdateCallback;
        this.cdA = bVar;
        this.ccZ = adapter;
    }

    public final List<T> getCurrentList() {
        return this.cdC;
    }

    public final void submitList(final List<T> list) {
        List<T> list2 = this.SW;
        if (list == list2) {
            return;
        }
        final int i = this.cdD + 1;
        this.cdD = i;
        if (list == null) {
            this.cdz.onRemoved(0, list2.size());
            this.SW = null;
            this.cdC = Collections.emptyList();
        } else if (list2 == null) {
            this.cdz.onInserted(0, list.size());
            this.SW = list;
            this.cdC = Collections.unmodifiableList(list);
        } else {
            this.cdB = true;
            final List<T> list3 = this.SW;
            this.cdA.getBackgroundThreadExecutor().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.a.a.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    final DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.kwad.sdk.lib.widget.a.a.d.1.1
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final int getOldListSize() {
                            return list3.size();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final int getNewListSize() {
                            return list.size();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final boolean areItemsTheSame(int i2, int i3) {
                            return d.this.cdA.alb().areItemsTheSame(list3.get(i2), list.get(i3));
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final boolean areContentsTheSame(int i2, int i3) {
                            return d.this.cdA.alb().areContentsTheSame(list3.get(i2), list.get(i3));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final Object getChangePayload(int i2, int i3) {
                            list3.get(i2);
                            list.get(i3);
                            return null;
                        }
                    });
                    d.this.cdA.getMainThreadExecutor().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.a.a.d.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (d.this.cdD == i) {
                                d.this.a(list, diffResultCalculateDiff);
                            }
                        }
                    });
                }
            });
        }
    }

    public final void aD(List<T> list) {
        this.SW = list;
        this.cdC = Collections.unmodifiableList(list);
        this.ccZ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<T> list, DiffUtil.DiffResult diffResult) {
        this.SW = list;
        this.cdC = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.cdz);
        this.cdB = false;
        if (this.cdA.alc() != null) {
            this.cdA.alc().run();
        }
    }
}
