package com.component.feed;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.container.s.ab;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.ci;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ae extends com.baidu.mobads.container.s.ab implements ci.b, al {
    private static final String b = ae.class.getSimpleName();
    private volatile boolean d;
    private final ak e;
    private Runnable f;
    private Runnable g;
    private int h;
    private int i;
    private int j;

    public ae(Context context, ab.b bVar, boolean z, a aVar, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar, boolean z2) {
        super(context, bVar, z, aVar, kVar, jVar, z2);
        this.d = false;
        this.h = 1;
        this.i = 0;
        this.j = 1000;
        aVar.a(this);
        this.e = ak.a(context);
    }

    public ae(Context context, ab.b bVar, boolean z, a aVar) {
        super(context, bVar, z, aVar);
        this.d = false;
        this.h = 1;
        this.i = 0;
        this.j = 1000;
        aVar.a(this);
        this.e = ak.a(context);
    }

    @Override // com.baidu.mobads.container.s.ab, com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f == null) {
            this.f = new af(this);
        }
        postDelayed(this.f, d());
        r();
        this.i = 0;
    }

    @Override // com.baidu.mobads.container.s.ab, com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }

    @Override // com.baidu.mobads.container.util.ci.b
    public void a(View view, boolean z) {
        this.d = z;
        if (z && this.i < this.h) {
            i();
            if (this.g == null) {
                this.g = new ag(this);
                postDelayed(this.g, e());
                return;
            }
            return;
        }
        j();
    }

    @Override // com.component.feed.al
    public boolean o() {
        return this.d;
    }

    @Override // com.baidu.mobads.container.s.ab
    public void m() {
        super.m();
        s();
        this.e.b(this);
        setVisibility(4);
        removeCallbacks(this.f);
        removeCallbacks(this.g);
        this.f = null;
        this.g = null;
    }

    public static class a implements com.baidu.mobads.container.util.g.b {
        private final com.baidu.mobads.container.util.g.b a;
        private ae b;

        public a(com.baidu.mobads.container.util.g.b bVar) {
            this.a = bVar;
        }

        public void a(ae aeVar) {
            this.b = aeVar;
        }

        @Override // com.baidu.mobads.container.util.g.b
        public void a(float f, float f2) {
            this.b.a(this.a, f, f2);
        }

        @Override // com.baidu.mobads.container.util.g.b
        public void a(float f) {
            if (this.a != null) {
                this.a.a(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.mobads.container.util.g.b bVar, float f, float f2) {
        if (this.d && this.e.c(this)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.e.a() > this.j) {
                this.e.a(jCurrentTimeMillis);
                this.i++;
                if (bVar != null) {
                    bVar.a(f, f2);
                }
                if (this.i >= this.h) {
                    m();
                }
            }
        }
    }

    private void r() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("window_focus", true);
            jSONObject.put("visible_percent", 100);
            ci.a().a(this, this, jSONObject);
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    private void s() {
        ci.a().b(this);
    }
}
