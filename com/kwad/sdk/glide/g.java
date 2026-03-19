package com.kwad.sdk.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.kwad.sdk.glide.a.c;
import com.kwad.sdk.glide.a.i;
import com.kwad.sdk.glide.a.l;
import com.kwad.sdk.glide.a.m;
import com.kwad.sdk.glide.a.o;
import com.kwad.sdk.glide.e.j;
import com.kwad.sdk.glide.request.a.k;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g implements i {
    private final Handler agB;
    protected final c bPw;
    private final CopyOnWriteArrayList<com.kwad.sdk.glide.request.h<Object>> bQA;
    private com.kwad.sdk.glide.request.i bQB;
    final com.kwad.sdk.glide.a.h bQu;
    private final m bQv;
    private final l bQw;
    private final o bQx;
    private final Runnable bQy;
    private final com.kwad.sdk.glide.a.c bQz;
    protected final Context dR;
    private static final com.kwad.sdk.glide.request.i bQs = com.kwad.sdk.glide.request.i.w(Bitmap.class).aiD();
    private static final com.kwad.sdk.glide.request.i bQt = com.kwad.sdk.glide.request.i.w(com.kwad.sdk.glide.load.resource.d.c.class).aiD();
    private static final com.kwad.sdk.glide.request.i bQf = com.kwad.sdk.glide.request.i.b(com.kwad.sdk.glide.load.engine.h.bTr).b(Priority.LOW).cU(true);

    public g(c cVar, com.kwad.sdk.glide.a.h hVar, l lVar, Context context) {
        this(cVar, hVar, lVar, new m(), cVar.afb(), context);
    }

    private g(c cVar, com.kwad.sdk.glide.a.h hVar, l lVar, m mVar, com.kwad.sdk.glide.a.d dVar, Context context) {
        this.bQx = new o();
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.glide.g.1
            @Override // java.lang.Runnable
            public final void run() {
                g.this.bQu.a(g.this);
            }
        };
        this.bQy = runnable;
        Handler handler = new Handler(Looper.getMainLooper());
        this.agB = handler;
        this.bPw = cVar;
        this.bQu = hVar;
        this.bQw = lVar;
        this.bQv = mVar;
        this.dR = context;
        com.kwad.sdk.glide.a.c cVarA = dVar.a(context.getApplicationContext(), new b(mVar));
        this.bQz = cVarA;
        if (j.ajE()) {
            handler.post(runnable);
        } else {
            hVar.a(this);
        }
        hVar.a(cVarA);
        this.bQA = new CopyOnWriteArrayList<>(cVar.afc().aff());
        a(cVar.afc().afg());
        cVar.a(this);
    }

    protected synchronized void a(com.kwad.sdk.glide.request.i iVar) {
        this.bQB = iVar.clone().aiE();
    }

    private synchronized void afo() {
        this.bQv.afo();
    }

    private synchronized void afp() {
        this.bQv.afp();
    }

    @Override // com.kwad.sdk.glide.a.i
    public synchronized void onStart() {
        afp();
        this.bQx.onStart();
    }

    @Override // com.kwad.sdk.glide.a.i
    public synchronized void onStop() {
        afo();
        this.bQx.onStop();
    }

    @Override // com.kwad.sdk.glide.a.i
    public synchronized void onDestroy() {
        this.bQx.onDestroy();
        Iterator<com.kwad.sdk.glide.request.a.j<?>> it = this.bQx.aaj().iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.bQx.clear();
        this.bQv.aip();
        this.bQu.b(this);
        this.bQu.b(this.bQz);
        this.agB.removeCallbacks(this.bQy);
        this.bPw.b(this);
    }

    public f<Bitmap> afq() {
        return i(Bitmap.class).a(bQs);
    }

    public f<Drawable> afr() {
        return i(Drawable.class);
    }

    public f<Drawable> hh(String str) {
        return afr().hh(str);
    }

    public f<File> afs() {
        return i(File.class).a(bQf);
    }

    public <ResourceType> f<ResourceType> i(Class<ResourceType> cls) {
        return new f<>(this.bPw, this, cls, this.dR);
    }

    public final void ac(View view) {
        c(new a(view));
    }

    public final synchronized void c(com.kwad.sdk.glide.request.a.j<?> jVar) {
        if (jVar == null) {
            return;
        }
        d(jVar);
    }

    private void d(com.kwad.sdk.glide.request.a.j<?> jVar) {
        if (e(jVar) || this.bPw.a(jVar) || jVar.getRequest() == null) {
            return;
        }
        com.kwad.sdk.glide.request.e request = jVar.getRequest();
        jVar.setRequest(null);
        request.clear();
    }

    final synchronized boolean e(com.kwad.sdk.glide.request.a.j<?> jVar) {
        com.kwad.sdk.glide.request.e request = jVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.bQv.b(request)) {
            return false;
        }
        this.bQx.g(jVar);
        jVar.setRequest(null);
        return true;
    }

    final synchronized void a(com.kwad.sdk.glide.request.a.j<?> jVar, com.kwad.sdk.glide.request.e eVar) {
        this.bQx.f(jVar);
        this.bQv.a(eVar);
    }

    final List<com.kwad.sdk.glide.request.h<Object>> aff() {
        return this.bQA;
    }

    final synchronized com.kwad.sdk.glide.request.i afg() {
        return this.bQB;
    }

    final <T> h<?, T> h(Class<T> cls) {
        return this.bPw.afc().h(cls);
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.bQv + ", treeNode=" + this.bQw + com.alipay.sdk.m.u.i.d;
    }

    class b implements c.a {
        private final m bQv;

        b(m mVar) {
            this.bQv = mVar;
        }

        @Override // com.kwad.sdk.glide.a.c.a
        public final void cO(boolean z) {
            if (z) {
                synchronized (g.this) {
                    this.bQv.aiq();
                }
            }
        }
    }

    static class a extends k<View, Object> {
        @Override // com.kwad.sdk.glide.request.a.j
        public final void onResourceReady(Object obj, com.kwad.sdk.glide.request.b.b<? super Object> bVar) {
        }

        a(View view) {
            super(view);
        }
    }
}
