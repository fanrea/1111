package com.component.feed;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.container.util.bv;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ak {
    private static volatile ak a;
    private final int b;
    private final int c;
    private final CopyOnWriteArrayList<a> d = new CopyOnWriteArrayList<>();
    private volatile long e = 0;

    public static ak a(Context context) {
        if (a == null) {
            synchronized (ak.class) {
                if (a == null) {
                    a = new ak(context);
                }
            }
        }
        return a;
    }

    private ak(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = bv.b(applicationContext);
        this.c = bv.c(applicationContext);
    }

    public boolean a(View view) {
        if (view != null) {
            if (d(view) == null) {
                return this.d.add(new a(view));
            }
            return true;
        }
        return false;
    }

    public void b(View view) {
        a aVarD = d(view);
        if (aVarD != null) {
            aVarD.b();
        }
        b();
    }

    public long a() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean c(View view) {
        int iE;
        int i = this.c / 2;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.d.size(); i4++) {
            View viewA = this.d.get(i4).a();
            if (viewA == view) {
                i3 = i4;
            }
            if ((viewA instanceof al) && ((al) viewA).o() && (iE = e(viewA)) < i) {
                i2 = i4;
                i = iE;
            }
        }
        return i2 == i3;
    }

    private a d(View view) {
        Iterator<a> it = this.d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                if (next.a() == null) {
                    next.b();
                } else if (next.a(view)) {
                    return next;
                }
            }
        }
        return null;
    }

    private void b() {
        int i = 0;
        while (i < this.d.size()) {
            a aVar = this.d.get(i);
            if (aVar != null && aVar.c()) {
                this.d.remove(aVar);
            } else {
                i++;
            }
        }
    }

    private int e(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs(iArr[1] - (this.c / 2));
    }

    private static class a {
        WeakReference<View> a;
        int b = 0;

        public a(View view) {
            this.a = new WeakReference<>(view);
        }

        public boolean a(View view) {
            return view == this.a.get();
        }

        public View a() {
            return this.a.get();
        }

        public void b() {
            this.b = -1;
        }

        public boolean c() {
            return this.b < 0;
        }
    }
}
