package android.support.v7.widget;

import android.support.v7.widget.aj;
import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class aa implements Runnable {
    static final ThreadLocal<aa> pt = new ThreadLocal<>();
    static Comparator<b> py = new Comparator<b>() { // from class: android.support.v7.widget.aa.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(b bVar, b bVar2) {
            return a(bVar, bVar2);
        }

        private static int a(b bVar, b bVar2) {
            if ((bVar.pF == null) != (bVar2.pF == null)) {
                return bVar.pF == null ? 1 : -1;
            }
            if (bVar.pC != bVar2.pC) {
                return bVar.pC ? -1 : 1;
            }
            int i = bVar2.pD - bVar.pD;
            if (i != 0) {
                return i;
            }
            int i2 = bVar.pE - bVar2.pE;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    long pv;
    long pw;
    ArrayList<aj> pu = new ArrayList<>();
    private ArrayList<b> px = new ArrayList<>();

    aa() {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class b {
        public boolean pC;
        public int pD;
        public int pE;
        public aj pF;
        public int position;

        b() {
        }

        public final void clear() {
            this.pC = false;
            this.pD = 0;
            this.pE = 0;
            this.pF = null;
            this.position = 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a implements aj.i.a {
        int mCount;
        int pA;
        int[] pB;
        int pz;

        a() {
        }

        final void z(int i, int i2) {
            this.pz = i;
            this.pA = i2;
        }

        final void a(aj ajVar, boolean z) {
            this.mCount = 0;
            int[] iArr = this.pB;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            aj.i iVar = ajVar.mLayout;
            if (ajVar.mAdapter == null || iVar == null || !iVar.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!ajVar.mAdapterHelper.cA()) {
                    iVar.collectInitialPrefetchPositions(ajVar.mAdapter.getItemCount(), this);
                }
            } else if (!ajVar.hasPendingAdapterUpdates()) {
                iVar.collectAdjacentPrefetchPositions(this.pz, this.pA, ajVar.mState, this);
            }
            if (this.mCount > iVar.mPrefetchMaxCountObserved) {
                iVar.mPrefetchMaxCountObserved = this.mCount;
                iVar.mPrefetchMaxObservedInInitialPrefetch = z;
                ajVar.mRecycler.dX();
            }
        }

        @Override // android.support.v7.widget.aj.i.a
        public final void A(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.mCount * 2;
            int[] iArr = this.pB;
            if (iArr == null) {
                this.pB = new int[4];
                Arrays.fill(this.pB, -1);
            } else if (i3 >= iArr.length) {
                this.pB = new int[i3 * 2];
                System.arraycopy(iArr, 0, this.pB, 0, iArr.length);
            }
            int[] iArr2 = this.pB;
            iArr2[i3] = i;
            iArr2[i3 + 1] = i2;
            this.mCount++;
        }

        final boolean aj(int i) {
            if (this.pB != null) {
                int i2 = this.mCount * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.pB[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        final void dn() {
            int[] iArr = this.pB;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mCount = 0;
        }
    }

    public final void b(aj ajVar) {
        this.pu.add(ajVar);
    }

    public final void c(aj ajVar) {
        this.pu.remove(ajVar);
    }

    final void a(aj ajVar, int i, int i2) {
        if (ajVar.isAttachedToWindow() && this.pv == 0) {
            this.pv = ajVar.getNanoTime();
            ajVar.post(this);
        }
        ajVar.mPrefetchRegistry.z(i, i2);
    }

    private void dm() {
        b bVar;
        int size = this.pu.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            aj ajVar = this.pu.get(i2);
            if (ajVar.getWindowVisibility() == 0) {
                ajVar.mPrefetchRegistry.a(ajVar, false);
                i += ajVar.mPrefetchRegistry.mCount;
            }
        }
        this.px.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            aj ajVar2 = this.pu.get(i4);
            if (ajVar2.getWindowVisibility() == 0) {
                a aVar = ajVar2.mPrefetchRegistry;
                int iAbs = Math.abs(aVar.pz) + Math.abs(aVar.pA);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.mCount * 2; i6 += 2) {
                    if (i5 >= this.px.size()) {
                        bVar = new b();
                        this.px.add(bVar);
                    } else {
                        bVar = this.px.get(i5);
                    }
                    int i7 = aVar.pB[i6 + 1];
                    bVar.pC = i7 <= iAbs;
                    bVar.pD = iAbs;
                    bVar.pE = i7;
                    bVar.pF = ajVar2;
                    bVar.position = aVar.pB[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.px, py);
    }

    private static boolean a(aj ajVar, int i) {
        int iCV = ajVar.mChildHelper.cV();
        for (int i2 = 0; i2 < iCV; i2++) {
            aj.x childViewHolderInt = aj.getChildViewHolderInt(ajVar.mChildHelper.af(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private static aj.x a(aj ajVar, int i, long j) {
        if (a(ajVar, i)) {
            return null;
        }
        aj.p pVar = ajVar.mRecycler;
        try {
            ajVar.onEnterLayoutOrScroll();
            aj.x xVarA = pVar.a(i, false, j);
            if (xVarA != null) {
                if (xVarA.isBound() && !xVarA.isInvalid()) {
                    pVar.U(xVarA.itemView);
                } else {
                    pVar.a(xVarA, false);
                }
            }
            return xVarA;
        } finally {
            ajVar.onExitLayoutOrScroll(false);
        }
    }

    private void a(aj ajVar, long j) {
        if (ajVar == null) {
            return;
        }
        if (ajVar.mDataSetHasChangedAfterLayout && ajVar.mChildHelper.cV() != 0) {
            ajVar.removeAndRecycleViews();
        }
        a aVar = ajVar.mPrefetchRegistry;
        aVar.a(ajVar, true);
        if (aVar.mCount != 0) {
            try {
                android.support.v4.os.a.beginSection("RV Nested Prefetch");
                ajVar.mState.a(ajVar.mAdapter);
                for (int i = 0; i < aVar.mCount * 2; i += 2) {
                    a(ajVar, aVar.pB[i], j);
                }
            } finally {
                android.support.v4.os.a.endSection();
            }
        }
    }

    private void a(b bVar, long j) {
        aj.x xVarA = a(bVar.pF, bVar.position, bVar.pC ? LocationRequestCompat.PASSIVE_INTERVAL : j);
        if (xVarA == null || xVarA.mNestedRecyclerView == null || !xVarA.isBound() || xVarA.isInvalid()) {
            return;
        }
        a(xVarA.mNestedRecyclerView.get(), j);
    }

    private void g(long j) {
        for (int i = 0; i < this.px.size(); i++) {
            b bVar = this.px.get(i);
            if (bVar.pF == null) {
                return;
            }
            a(bVar, j);
            bVar.clear();
        }
    }

    private void h(long j) {
        dm();
        g(j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            android.support.v4.os.a.beginSection("RV Prefetch");
            if (!this.pu.isEmpty()) {
                int size = this.pu.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    aj ajVar = this.pu.get(i);
                    if (ajVar.getWindowVisibility() == 0) {
                        jMax = Math.max(ajVar.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    h(TimeUnit.MILLISECONDS.toNanos(jMax) + this.pw);
                }
            }
        } finally {
            this.pv = 0L;
            android.support.v4.os.a.endSection();
        }
    }
}
