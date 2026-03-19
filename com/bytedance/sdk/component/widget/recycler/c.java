package com.bytedance.sdk.component.widget.recycler;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class c implements Runnable {
    static final ThreadLocal<c> d = new ThreadLocal<>();
    static Comparator<hc> u = new Comparator<hc>() { // from class: com.bytedance.sdk.component.widget.recycler.c.1
        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(hc hcVar, hc hcVar2) {
            if ((hcVar.c == null) != (hcVar2.c == null)) {
                return hcVar.c == null ? 1 : -1;
            }
            if (hcVar.d != hcVar2.d) {
                return hcVar.d ? -1 : 1;
            }
            int i = hcVar2.hc - hcVar.hc;
            if (i != 0) {
                return i;
            }
            int i2 = hcVar.b - hcVar2.b;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    long b;
    long c;
    ArrayList<RecyclerView> hc = new ArrayList<>();
    private ArrayList<hc> an = new ArrayList<>();

    c() {
    }

    public void d(RecyclerView recyclerView) {
        this.hc.add(recyclerView);
    }

    public void hc(RecyclerView recyclerView) {
        this.hc.remove(recyclerView);
    }

    void d(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.b == 0) {
            this.b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.zw.d(i, i2);
    }

    private void d() {
        hc hcVar;
        int size = this.hc.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.hc.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.zw.d(recyclerView, false);
                i += recyclerView.zw.c;
            }
        }
        this.an.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.hc.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                d dVar = recyclerView2.zw;
                int iAbs = Math.abs(dVar.d) + Math.abs(dVar.hc);
                for (int i5 = 0; i5 < dVar.c * 2; i5 += 2) {
                    if (i3 >= this.an.size()) {
                        hcVar = new hc();
                        this.an.add(hcVar);
                    } else {
                        hcVar = this.an.get(i3);
                    }
                    int i6 = dVar.b[i5 + 1];
                    hcVar.d = i6 <= iAbs;
                    hcVar.hc = iAbs;
                    hcVar.b = i6;
                    hcVar.c = recyclerView2;
                    hcVar.u = dVar.b[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.an, u);
    }

    static boolean d(RecyclerView recyclerView, int i) {
        int iB = recyclerView.h.b();
        for (int i2 = 0; i2 < iB; i2++) {
            RecyclerView.v vVarU = RecyclerView.u(recyclerView.h.c(i2));
            if (vVarU.b == i && !vVarU.k()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.v d(RecyclerView recyclerView, int i, long j) {
        if (d(recyclerView, i)) {
            return null;
        }
        RecyclerView.cb cbVar = recyclerView.u;
        try {
            recyclerView.mq();
            RecyclerView.v vVarD = cbVar.d(i, false, j);
            if (vVarD != null) {
                if (vVarD.cb() && !vVarD.k()) {
                    cbVar.d(vVarD.d);
                } else {
                    cbVar.d(vVarD, false);
                }
            }
            return vVarD;
        } finally {
            recyclerView.hc(false);
        }
    }

    private void d(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.v && recyclerView.h.b() != 0) {
                recyclerView.b();
            }
            d dVar = recyclerView.zw;
            dVar.d(recyclerView, true);
            if (dVar.c != 0) {
                try {
                    com.bytedance.sdk.component.widget.recycler.d.d.d.d("RV Nested Prefetch");
                    recyclerView.j.d(recyclerView.uo);
                    for (int i = 0; i < dVar.c * 2; i += 2) {
                        d(recyclerView, dVar.b[i], j);
                    }
                } finally {
                    com.bytedance.sdk.component.widget.recycler.d.d.d.d();
                }
            }
        }
    }

    private void d(hc hcVar, long j) {
        RecyclerView.v vVarD = d(hcVar.c, hcVar.u, hcVar.d ? LocationRequestCompat.PASSIVE_INTERVAL : j);
        if (vVarD == null || vVarD.hc == null || !vVarD.cb() || vVarD.k()) {
            return;
        }
        d(vVarD.hc.get(), j);
    }

    private void hc(long j) {
        for (int i = 0; i < this.an.size(); i++) {
            hc hcVar = this.an.get(i);
            if (hcVar.c == null) {
                return;
            }
            d(hcVar, j);
            hcVar.d();
        }
    }

    void d(long j) {
        d();
        hc(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.bytedance.sdk.component.widget.recycler.d.d.d.d("RV Prefetch");
            if (!this.hc.isEmpty()) {
                int size = this.hc.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.hc.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    d(TimeUnit.MILLISECONDS.toNanos(jMax) + this.c);
                }
            }
        } finally {
            this.b = 0L;
            com.bytedance.sdk.component.widget.recycler.d.d.d.d();
        }
    }

    static class d implements RecyclerView.tt.d {
        int[] b;
        int c;
        int d;
        int hc;

        d() {
        }

        void d(int i, int i2) {
            this.d = i;
            this.hc = i2;
        }

        void d(RecyclerView recyclerView, boolean z) {
            this.c = 0;
            int[] iArr = this.b;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.tt ttVar = recyclerView.k;
            if (recyclerView.uo == null || ttVar == null || !ttVar.k()) {
                return;
            }
            if (z) {
                if (!recyclerView.an.c()) {
                    ttVar.d(recyclerView.uo.d(), this);
                }
            } else if (!recyclerView.sy()) {
                ttVar.d(this.d, this.hc, recyclerView.j, this);
            }
            if (this.c > ttVar.cb) {
                ttVar.cb = this.c;
                ttVar.w = z;
                recyclerView.u.hc();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt.d
        public void hc(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.c * 2;
            int[] iArr = this.b;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.b = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.b = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.b;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.c++;
        }

        boolean d(int i) {
            if (this.b != null) {
                int i2 = this.c * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.b[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void d() {
            int[] iArr = this.b;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.c = 0;
        }
    }

    static class hc {
        public int b;
        public RecyclerView c;
        public boolean d;
        public int hc;
        public int u;

        hc() {
        }

        public void d() {
            this.d = false;
            this.hc = 0;
            this.b = 0;
            this.c = null;
            this.u = 0;
        }
    }
}
