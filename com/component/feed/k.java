package com.component.feed;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k {
    public static final String a = "VideoViewManager";
    private ArrayList<m> b;
    private m c;
    private boolean d;
    private float e;

    private k() {
        this.d = true;
        this.e = 1.0f;
        this.b = new ArrayList<>();
    }

    public static k a() {
        return a.a;
    }

    public m b() {
        return this.c;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(float f) {
        this.e = f;
    }

    public boolean c() {
        return this.d;
    }

    public float d() {
        return this.e;
    }

    private static final class a {
        private static final k a = new k();

        private a() {
        }
    }

    public boolean e() {
        return this.c != null && this.c.x();
    }

    public void a(m mVar) {
        this.b.remove(mVar);
        if (this.b.isEmpty()) {
            g();
        }
    }

    private void g() {
        this.c = null;
    }

    public void a(m mVar, String str) {
        if (!this.b.contains(mVar)) {
            this.b.add(mVar);
        }
        if (m.ad.equals(str) && e()) {
            return;
        }
        if (m.ad.equals(str) && (mVar.T || mVar.P)) {
            return;
        }
        if (m.ac.equals(str) && (mVar.T || mVar.P)) {
            return;
        }
        this.c = mVar;
        this.c.c(str);
        Iterator<m> it = this.b.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next != mVar) {
                if (m.ae.equals(str) || m.af.equals(str)) {
                    next.d(m.ab);
                } else {
                    next.d((String) null);
                }
            }
        }
    }

    public void b(m mVar) {
        if (!this.b.contains(mVar)) {
            this.b.add(mVar);
        }
    }

    public m f() {
        m mVar = null;
        for (int i = 0; i < this.b.size(); i++) {
            if ("ad".equals(this.b.get(i).I().getType())) {
                m mVar2 = this.b.get(i);
                if (mVar == null || c(mVar2) <= c(mVar)) {
                    mVar = mVar2;
                }
            }
        }
        return mVar;
    }

    private int c(m mVar) {
        Rect rect = new Rect();
        mVar.getGlobalVisibleRect(rect);
        return rect.top;
    }
}
