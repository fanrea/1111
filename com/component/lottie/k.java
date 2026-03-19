package com.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.d.d;
import com.component.a.f.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k {
    private static final long a = 5000;
    private final Context b;
    private final e.h e;
    private final String f;
    private final Map<String, String> g;
    private t k;
    private volatile boolean j = false;
    private final String h = a();
    private final Map<String, Bitmap> c = new HashMap();
    private final a d = new a(this, null);
    private final Handler i = new Handler(Looper.getMainLooper());

    public interface b {
        void a(e.h hVar, t tVar);

        void a(e.h hVar, String str);

        void b(e.h hVar, t tVar);
    }

    public k(Context context, e.h hVar) {
        this.b = context.getApplicationContext();
        this.e = hVar;
        this.f = hVar.h("");
        this.g = hVar.a();
    }

    public static void a(Context context, e.h hVar, b bVar) {
        a(context, hVar, 5000L, bVar);
    }

    public static void a(Context context, e.h hVar, long j, b bVar) {
        new k(context, hVar).a(j, bVar);
    }

    private String a() {
        StringBuilder sb = new StringBuilder(this.f);
        ArrayList arrayList = new ArrayList(this.g.values());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        return sb.toString();
    }

    public void a(b bVar) {
        a(5000L, bVar);
    }

    public void a(long j, b bVar) {
        if (bVar == null || TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.h)) {
            return;
        }
        try {
            long jMax = Math.max(0L, j);
            this.j = false;
            this.i.postDelayed(new l(this, bVar), jMax);
            bc<t> bcVarB = com.baidu.mobads.container.util.b.a.a(this.b).b(this.h, this.f);
            if (bcVarB != null) {
                bcVarB.a(new n(this, bVar)).c(new m(this, bVar));
            } else {
                c cVar = new c(bVar);
                a(cVar);
                a(cVar, bVar);
            }
        } catch (Throwable th) {
            a(bVar, th.getMessage());
        }
    }

    private void a(c cVar) {
        com.baidu.mobads.container.util.d.d.a(this.b, this.f).a.a(d.e.COMMON).a((d.InterfaceC0136d) cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bc<t> bcVarB = com.baidu.mobads.container.util.b.a.a(this.b).b(this.h, this.f);
        if (bcVarB != null) {
            bcVarB.a(new p(this, bVar)).c(new o(this, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, b bVar) {
        try {
            Iterator<String> it = this.g.keySet().iterator();
            while (it.hasNext()) {
                com.baidu.mobads.container.util.d.d.a(this.b, this.g.get(it.next())).a.a(d.e.COMMON).a((d.InterfaceC0136d) cVar);
            }
        } catch (Throwable th) {
            com.component.lottie.g.c.c("Error caching bitmap.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(b bVar) {
        if (bVar != null && this.k != null && this.k.q()) {
            if (!this.j) {
                this.j = true;
                this.i.post(new q(this, bVar));
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        if (bVar != null) {
            this.i.post(new r(this, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, String str) {
        if (bVar != null && !this.j) {
            this.j = true;
            this.i.removeCallbacksAndMessages(null);
            this.i.post(new s(this, bVar, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c extends com.baidu.mobads.container.util.d.a {
        private final b b;

        c(b bVar) {
            this.b = bVar;
        }

        @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
            k.this.a(this.b, "Loading lottie online failed.");
        }

        @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, Bitmap bitmap) {
            try {
                if (TextUtils.equals(str2, k.this.f)) {
                    k.this.b(this.b);
                } else if (bitmap != null) {
                    k.this.c.put(str2, bitmap);
                    if (k.this.k != null) {
                        k.this.k.a(k.this.d);
                        k.this.c(this.b);
                    }
                }
            } catch (Throwable th) {
                k.this.a(this.b, th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class a implements com.component.lottie.b {
        private a() {
        }

        /* synthetic */ a(k kVar, l lVar) {
            this();
        }

        @Override // com.component.lottie.b
        public Bitmap a(ax axVar) {
            Bitmap bitmap;
            try {
                String strC = axVar.c();
                if (k.this.g != null && !TextUtils.isEmpty(strC)) {
                    String str = (String) k.this.g.get(strC);
                    if (!TextUtils.isEmpty(str) && (bitmap = (Bitmap) k.this.c.get(str)) != null) {
                        return com.component.lottie.g.g.a(bitmap, axVar.a(), axVar.b());
                    }
                }
            } catch (Throwable th) {
                bq.a().a(th.getMessage());
            }
            return axVar.f();
        }
    }
}
