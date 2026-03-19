package android.support.v7.widget;

import android.database.DataSetObserver;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface af {
    void a(android.support.v7.view.menu.g gVar, MenuItem menuItem);

    void b(android.support.v7.view.menu.g gVar, MenuItem menuItem);

    /* renamed from: android.support.v7.widget.af$1, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            View anchorView = af.this.getAnchorView();
            if (anchorView == null || anchorView.getWindowToken() == null) {
                return;
            }
            af.this.show();
        }
    }

    /* renamed from: android.support.v7.widget.af$2, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass2 implements AdapterView.OnItemSelectedListener {
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            w wVar;
            if (i == -1 || (wVar = af.this.rL) == null) {
                return;
            }
            wVar.setListSelectionHidden(false);
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            if (af.this.isShowing()) {
                af.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            af.this.dismiss();
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            af.this.clearListSelection();
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (af.this.rL == null || !android.support.v4.e.o.o((View) af.this.rL) || af.this.rL.getCount() <= af.this.rL.getChildCount() || af.this.rL.getChildCount() > af.this.rV) {
                return;
            }
            af.this.sj.setInputMethodMode(2);
            af.this.show();
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && af.this.sj != null && af.this.sj.isShowing() && x >= 0 && x < af.this.sj.getWidth() && y >= 0 && y < af.this.sj.getHeight()) {
                af.this.mHandler.postDelayed(af.this.sd, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            af.this.mHandler.removeCallbacks(af.this.sd);
            return false;
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    class c implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || af.this.isInputMethodNotNeeded() || af.this.sj.getContentView() == null) {
                return;
            }
            af.this.mHandler.removeCallbacks(af.this.sd);
            af.this.sd.run();
        }
    }
}
